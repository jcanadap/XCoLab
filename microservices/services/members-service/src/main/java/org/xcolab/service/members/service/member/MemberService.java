package org.xcolab.service.members.service.member;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.xcolab.client.tracking.TrackingClient;
import org.xcolab.client.tracking.pojo.Location;
import org.xcolab.commons.exceptions.ReferenceResolutionException;
import org.xcolab.model.tables.pojos.LoginLog;
import org.xcolab.model.tables.pojos.Member;
import org.xcolab.service.members.domain.loginlog.LoginLogDao;
import org.xcolab.service.members.domain.member.MemberDao;
import org.xcolab.service.members.domain.role.RoleDao;
import org.xcolab.service.members.exceptions.NotFoundException;
import org.xcolab.service.members.util.PBKDF2PasswordEncryptor;
import org.xcolab.service.members.util.SHA1PasswordEncryptor;
import org.xcolab.service.members.util.SecureRandomUtil;
import org.xcolab.service.members.util.UsernameGenerator;
import org.xcolab.service.members.util.email.ConnectorEmmaAPI;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class MemberService {

    private static final int MAX_SCREEN_NAME_LENGTH = 26;

    private final MemberDao memberDao;
    private final RoleDao roleDao;
    private final LoginLogDao loginLogDao;
    private final ConnectorEmmaAPI connectorEmmaAPI;

    @Autowired
    public MemberService(MemberDao memberDao, RoleDao roleDao, LoginLogDao loginLogDao,
            ConnectorEmmaAPI connectorEmmaAPI) {
        this.memberDao = memberDao;
        this.roleDao = roleDao;
        this.loginLogDao = loginLogDao;
        this.connectorEmmaAPI = connectorEmmaAPI;
    }

    public String generateScreenName(String[] inputData) {
        UsernameGenerator usernameGenerator = new UsernameGenerator(inputData, false, MAX_SCREEN_NAME_LENGTH);

        String username;
        do {
            username = usernameGenerator.getNext();
        } while (memberDao.isScreenNameTaken(username));
        return username;
    }

    public String hashPassword(String password) {
        if (password == null) {
            return null;
        }
        PBKDF2PasswordEncryptor pbkdf2PasswordEncryptor = new PBKDF2PasswordEncryptor();
        return "PBKDF2_" + pbkdf2PasswordEncryptor
                .doEncrypt(PBKDF2PasswordEncryptor.DEFAULT_ALGORITHM, password, "");
    }

    public boolean validatePassword(String password, long memberId) throws NotFoundException {
        return validatePassword(password,
                memberDao.getMember(memberId).orElseThrow(NotFoundException::new).getHashedPassword());
    }

    public boolean validatePassword(String password, String hash) {
        if (StringUtils.isAnyEmpty(password, hash)) {
            return false;
        }
        SHA1PasswordEncryptor sha1PasswordEncryptor = new SHA1PasswordEncryptor();
        if (hash.startsWith("PBKDF2_")) {
            PBKDF2PasswordEncryptor pbkdf2PasswordEncryptor = new PBKDF2PasswordEncryptor();
            final String unprefixedHash = hash.substring(7);
            return pbkdf2PasswordEncryptor.doEncrypt(
                    PBKDF2PasswordEncryptor.DEFAULT_ALGORITHM, password, unprefixedHash)
                    .equals(unprefixedHash);
        }
        if (hash.startsWith("{SHA-1}")) {
            return sha1PasswordEncryptor.doEncrypt("SHA-1", password).equals(hash.substring(7));
        }
        return sha1PasswordEncryptor.doEncrypt("SHA-1", password).equals(hash);
    }

    public boolean updatePassword(long memberId, String newPassword) {
        final String hashedPassword = hashPassword(newPassword);
        return memberDao.updatePassword(memberId, hashedPassword);
    }

    public Member register(Member pojo) {
        pojo.setHashedPassword(hashPassword(pojo.getHashedPassword()));
        final Member member = memberDao.createMember(pojo);
        //TODO COLAB-2609: centralize this ID in constant (see MemberRole enum)
        roleDao.assignMemberRole(member.getId_(), 10122L);
        subscribeToNewsletter(member.getEmailAddress());
        return member;
    }

    public LoginLog createLoginLog(long memberId, String ipAddress, String redirectUrl) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(memberId);
        loginLog.setIpAddress(ipAddress);
        loginLog.setEntryUrl(StringUtils.left(redirectUrl, 250));

        final Location location = TrackingClient.getLocationForIp(ipAddress);
        if (location != null) {
            loginLog.setCountry(location.getCountry());
            loginLog.setCity(location.getCity());
        }

        return loginLogDao.create(loginLog);
    }

    public boolean validateForgotPasswordToken(String passwordToken) throws NotFoundException {
        if(memberDao.findOneByForgotPasswordHash(passwordToken).isPresent()) {
            Member member = memberDao.findOneByForgotPasswordHash(passwordToken).orElseThrow(NotFoundException::new);
            return member.getForgotPasswordTokenExpireTime().getTime() >= Timestamp
                    .valueOf(LocalDateTime.now()).getTime();
        } else {
            return false;
        }
    }

    public String createNewForgotPasswordToken(Long memberId) {
        Member member = memberDao.getMember(memberId).orElseThrow(
                () -> ReferenceResolutionException.toObject(Member.class, memberId).build());
        String confirmationToken = Long.toHexString(SecureRandomUtil.nextLong());
        member.setForgotPasswordToken(confirmationToken);
        LocalDateTime localDateTime = LocalDateTime.now().plusHours(1L);
        member.setForgotPasswordTokenExpireTime(Timestamp.valueOf(localDateTime));
        memberDao.updateMember(member);
        return confirmationToken;
    }

    public Long updateUserPasswordWithToken(String token, String newPassword) throws NotFoundException {
        Member member = memberDao.findOneByForgotPasswordHash(token).orElseThrow(NotFoundException::new);
        updatePassword(member.getId_(), newPassword);
        return member.getId_();
    }

    public boolean isSubscribedToNewsletter(long memberId) throws IOException, NotFoundException {
        final Member member = memberDao.getMember(memberId).orElseThrow(NotFoundException::new);
        final String email = member.getEmailAddress();
        JSONObject memberDetails = connectorEmmaAPI.getMemberJSONfromEmail(email);
        return ConnectorEmmaAPI.hasMemberActiveSubscription(memberDetails, false);
    }

    public boolean subscribeToNewsletter(long memberId) throws NotFoundException {
        final Member member = memberDao.getMember(memberId).orElseThrow(NotFoundException::new);
        final String email = member.getEmailAddress();
        return subscribeToNewsletter(email);
    }

    private boolean subscribeToNewsletter(String email) {
        try {
            JSONObject memberDetails = connectorEmmaAPI.subscribeMemberWithEmail(email);
            return ConnectorEmmaAPI.hasMemberActiveSubscription(memberDetails, true);
        } catch (IOException e) {
            return false;
        }
    }

    public boolean unsubscribeFromNewsletter(long memberId) throws NotFoundException {
        final Member member = memberDao.getMember(memberId).orElseThrow(NotFoundException::new);
        final String email = member.getEmailAddress();
        try {
            return connectorEmmaAPI.unSubscribeMemberWithEmail(email);
        } catch (IOException e) {
            return false;
        }
    }
}

package org.xcolab.client.members.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.text.WordUtils;
import org.springframework.core.ParameterizedTypeReference;

import org.xcolab.client.admin.attributes.configuration.ConfigurationAttributeKey;
import org.xcolab.client.admin.attributes.platform.PlatformAttributeKey;
import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.MessagingClient;
import org.xcolab.client.members.PermissionsClient;
import org.xcolab.util.http.client.types.TypeProvider;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Member implements Serializable {

    private static final long serialVersionUID = 1;

    @JsonIgnore
    private static final String USER_PROFILE_PATH = "/members/profile/%d";

    @JsonIgnore
    private static final String USER_PROFILE_EDIT_PATH = "/members/profile/%d/edit";

    @JsonIgnore
    private static final String USER_IMAGE_PATH = "/image/member/%d";

    public static final TypeProvider<Member> TYPES =
            new TypeProvider<>(Member.class,
                    new ParameterizedTypeReference<List<Member>>() {
                    });

    private long id_;
    private String screenName;
    private String emailAddress;
    private boolean isEmailConfirmed;
    private boolean isEmailBounced;
    private Timestamp createDate;
    private Timestamp modifiedDate;
    private Timestamp passwordModifiedDate;
    private String hashedPassword;
    private String firstName;
    private String lastName;
    private String country;
    private String shortBio;
    private Long facebookId;
    private String googleId;
    private String colabSsoId;
    private String climateXSsoId;
    private String openId;
    private String loginIP;
    private Timestamp loginDate;
    private Integer status;
    private int reportKarma;
    private Long portraitFileEntryId;
    private Integer   autoregisteredmemberstatus;
    private String    uuid;
    private String    defaultlocale;
    private String    loginTokenId;
    private String    loginTokenKey;
    private Timestamp loginTokenExpirationDate;

    public Member() {
    }

    public Member(Member value) {
        this.id_ = value.id_;
        this.screenName = value.screenName;
        this.emailAddress = value.emailAddress;
        this.isEmailConfirmed = value.isEmailConfirmed;
        this.isEmailBounced = value.isEmailBounced;
        this.createDate = value.createDate;
        this.modifiedDate = value.modifiedDate;
        this.passwordModifiedDate = value.passwordModifiedDate;
        this.hashedPassword = value.hashedPassword;
        this.firstName = value.firstName;
        this.lastName = value.lastName;
        this.country = value.country;
        this.shortBio = value.shortBio;
        this.facebookId = value.facebookId;
        this.googleId = value.googleId;
        this.colabSsoId = value.colabSsoId;
        this.climateXSsoId = value.climateXSsoId;
        this.openId = value.openId;
        this.loginIP = value.loginIP;
        this.loginDate = value.loginDate;
        this.status = value.status;
        this.reportKarma = value.reportKarma;
        this.portraitFileEntryId = value.portraitFileEntryId;
        this.autoregisteredmemberstatus = value.autoregisteredmemberstatus;
        this.uuid = value.uuid;
        this.defaultlocale = value.defaultlocale;
        this.loginTokenId = value.loginTokenId;
        this.loginTokenKey = value.loginTokenKey;
        this.loginTokenExpirationDate = value.loginTokenExpirationDate;
    }

    public static Member fromId(String memberIdString) {
        return fromId(Long.parseLong(memberIdString));
    }

    public static Member fromId(long memberId) {
        return MembersClient.getMemberUnchecked(memberId);
    }

    public long getId_() {
        return this.id_;
    }

    //For liferay/jsp compatibility
    @JsonIgnore
    public long getUserId() {
        return this.id_;
    }

    public void setId_(long id_) {
        this.id_ = id_;
    }

    public String getScreenName() {
        return this.screenName;
    }

    @JsonIgnore
    public String getDisplayName() {

        if (ConfigurationAttributeKey.DISPLAY_FIRST_NAME_LAST_NAME.get()) {
            return getFullName();
        } else {
            return screenName;
        }
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean getIsEmailConfirmed() {
        return isEmailConfirmed;
    }

    public void setIsEmailConfirmed(boolean emailConfirmed) {
        isEmailConfirmed = emailConfirmed;
    }

    public boolean getIsEmailBounced() {
        return isEmailBounced;
    }

    public void setIsEmailBounced(boolean emailBounced) {
        isEmailBounced = emailBounced;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Timestamp getPasswordModifiedDate() {
        return this.passwordModifiedDate;
    }

    public void setPasswordModifiedDate(Timestamp passwordModifiedDate) {
        this.passwordModifiedDate = passwordModifiedDate;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShortBio() {
        return this.shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public Long getFacebookId() {
        return this.facebookId;
    }

    public void setFacebookId(Long facebookId) {
        this.facebookId = facebookId;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getColabSsoId() {
        return colabSsoId;
    }

    public void setColabSsoId(String colabSsoId) {
        this.colabSsoId = colabSsoId;
    }

    public String getClimateXSsoId() {
        return climateXSsoId;
    }

    public void setClimateXSsoId(String climateXSsoId) {
        this.climateXSsoId = climateXSsoId;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getLoginIP() {
        return this.loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public Timestamp getLoginDate() {
        return this.loginDate;
    }

    public void setLoginDate(Timestamp loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getPortraitFileEntryId() {
        return this.portraitFileEntryId;
    }

    public void setPortraitFileEntryId(Long portraitfileentryid) {
        this.portraitFileEntryId = portraitfileentryid;
    }

    public String getDefaultLocale() {
        return this.defaultlocale;
    }

    public void setDefaultLocale(String defaultlocale) {
        this.defaultlocale = defaultlocale;
    }

    @JsonIgnore
    public long getPortraitId() {
        return getPortraitFileEntryId() != null ? getPortraitFileEntryId() : 0;
    }

    @JsonIgnore
    public Boolean isActive() {
        return this.status != null && this.status == 0;
    }

    @JsonIgnore
    public String getFullName() {
        final String fullName = WordUtils
                .capitalizeFully(this.getFirstName()+ " " + this.getLastName());
        if (StringUtils.isNotBlank(fullName)) {
            return fullName;
        }
        return screenName;
    }

    @JsonIgnore
    public boolean hasSameName(Member otherUser) {
        return StringUtils.equalsIgnoreCase(getFirstName(), otherUser.getFirstName())
                && StringUtils.equalsIgnoreCase(getLastName(), otherUser.getLastName());
    }

    @JsonIgnore
    public List<Role_> getRoles() {
        return MembersClient.getMemberRoles(this.getId_());
    }

    @JsonIgnore
    public boolean isVerifiedAccount() {
        return isEmailConfirmed;
    }

    @JsonIgnore
    public boolean hasLinkedSocialAccount() {
        return facebookId != null || StringUtils.isNotEmpty(googleId)
                || StringUtils.isNotEmpty(openId);
    }

    @JsonIgnore
    public boolean getIsAdmin() {
        return PermissionsClient.canAdminAll(this);
    }

    @JsonIgnore
    public int getUnreadMessageCount() {
        return MessagingClient.countUnreadMessagesForUser(getUserId());
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public int getReportKarma() {
        return reportKarma;
    }

    public void setReportKarma(int reportKarma) {
        this.reportKarma = reportKarma;
    }

    public Integer getAutoRegisteredMemberStatus() {
        return this.autoregisteredmemberstatus;
    }

    public void setAutoRegisteredMemberStatus(Integer autoregisteredmemberstatus) {
        this.autoregisteredmemberstatus = autoregisteredmemberstatus;
    }

    @JsonIgnore
    public String getOrGenerateUuid() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
            MembersClient.updateMember(this);
        }
        return uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLoginTokenId() {
        return loginTokenId;
    }

    public void setLoginTokenId(String loginTokenId) {
        this.loginTokenId = loginTokenId;
    }

    public String getLoginTokenKey() {
        return loginTokenKey;
    }

    public void setLoginTokenKey(String loginTokenKey) {
        this.loginTokenKey = loginTokenKey;
    }

    public Timestamp getLoginTokenExpirationDate() {
        return loginTokenExpirationDate;
    }

    public void setLoginTokenExpirationDate(Timestamp loginTokenExpirationDate) {
        this.loginTokenExpirationDate = loginTokenExpirationDate;
    }

    @JsonIgnore
    public String getProfileLinkUrl()  {
        return String.format(USER_PROFILE_PATH, getId_());
    }

    @JsonIgnore
    public String getProfileEditUrl()  {
        return String.format(USER_PROFILE_EDIT_PATH, getId_());
    }

    @JsonIgnore
    public String getImageLinkUrl() {
        final String userImageDomain = PlatformAttributeKey.CDN_URL_IMAGES_UPLOADED.get();
        return getPortraitId() != 0 ? userImageDomain + getRelativeImageUrl() : "";
    }

    @JsonIgnore
    public String getAbsoluteImageUrl() {
        final String cdnUrl = PlatformAttributeKey.CDN_URL_IMAGES_UPLOADED.get();
        final String userImageDomain = StringUtils.isNotEmpty(cdnUrl) ? cdnUrl
                : PlatformAttributeKey.COLAB_URL.get();
        return getPortraitId() != 0 ? userImageDomain + getRelativeImageUrl() : "";
    }

    private String getRelativeImageUrl() {
        return getPortraitId() != 0 ? String.format(USER_IMAGE_PATH, getPortraitId()) : "";
    }

    @JsonIgnore
    public String getLoginDateString() {
        return getLoginDate() != null ? getLoginDate().toString() : "";
    }

    @JsonIgnore
    public int getNumberOfMessagesLeft() {
        return MessagingClient.getNumberOfMessagesLeft(getId_());
    }

    public boolean getIsProfileComplete() {
        return firstName != null && lastName != null && emailAddress != null && country != null;
    }

    public void anonymize() {
        this.setFirstName("Member");
        this.setLastName("Removed");
        if (!this.getEmailAddress().startsWith("removed+userId")) {
            this.setEmailAddress("removed+userId"+this.getUserId()+"@climatecolab.org");
        }
        this.setFacebookId(null);
        this.setGoogleId(null);
        this.setOpenId(null);
        this.setColabSsoId(null);
        this.setClimateXSsoId(null);
        this.setLoginIP(null);
        this.setShortBio(null);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Member
                && ((Member) obj).getId_() == this.getId_();
    }

    @Override
    public int hashCode() {
        return (int) (this.getId_() ^ this.getId_() >>> 32);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id_", id_)
                .append("screenName", screenName)
                .append("emailAddress", emailAddress)
                .append("isEmailConfirmed", isEmailConfirmed)
                .append("isEmailBounced", isEmailBounced)
                .append("createDate", createDate)
                .append("modifiedDate", modifiedDate)
                .append("passwordModifiedDate", passwordModifiedDate)
                .append("hashedPassword", hashedPassword != null ? "REDACTED" : null)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("country", country)
                .append("shortBio", shortBio)
                .append("facebookId", facebookId)
                .append("googleId", googleId)
                .append("colabSsoId", colabSsoId)
                .append("climateXSsoId", climateXSsoId)
                .append("openId", openId)
                .append("loginIP", loginIP)
                .append("loginDate", loginDate)
                .append("status", status)
                .append("reportKarma", reportKarma)
                .append("portraitFileEntryId", portraitFileEntryId)
                .append("autoregisteredmemberstatus", autoregisteredmemberstatus)
                .append("uuid", uuid)
                .append("defaultlocale", defaultlocale)
                .append("loginTokenId", loginTokenId)
                .append("loginTokenKey", loginTokenKey != null ? "REDACTED" : null)
                .append("loginTokenExpirationDate", loginTokenExpirationDate).toString();
    }
}

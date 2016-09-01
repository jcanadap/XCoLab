package org.xcolab.service.members.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.xcolab.model.tables.pojos.Member;
import org.xcolab.model.tables.pojos.Role_;
import org.xcolab.service.members.domain.member.MemberDao;
import org.xcolab.service.members.exceptions.NotFoundException;
import org.xcolab.service.members.service.member.MemberService;
import org.xcolab.service.members.service.role.RoleService;
import org.xcolab.service.utils.ControllerUtils;
import org.xcolab.service.utils.PaginationHelper;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/members")
public class MembersController {

    private final MemberService memberService;

    private final MemberDao memberDao;

    private final RoleService roleService;

    @Autowired
    public MembersController(MemberDao memberDao, RoleService roleService,
            MemberService memberService) {
        this.memberDao = memberDao;
        this.roleService = roleService;
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> listMembers(HttpServletResponse response,
                                    @RequestParam(required = false) Integer startRecord,
                                    @RequestParam(required = false) Integer limitRecord,
                                    @RequestParam(required = false) String sort,
                                    @RequestParam(required = false) String partialName,
                                    @RequestParam(required = false) String roleName,
                                    @RequestParam(required = false) String email,
                                    @RequestParam(required = false) String screenName,
                                    @RequestParam(required = false) Long facebookId,
                                    @RequestParam(required = false) String openId) {
        PaginationHelper paginationHelper = new PaginationHelper(startRecord, limitRecord, sort);

        response.setHeader(ControllerUtils.COUNT_HEADER_NAME,
                Integer.toString(memberDao.countByGiven(partialName, roleName)));

        return memberDao.findByGiven(paginationHelper, partialName, roleName,
                email, screenName, facebookId, openId);
    }

    @GetMapping("{memberId}")
    public Member getMember(@PathVariable long memberId) throws NotFoundException {
        if (memberId == 0) {
            throw new NotFoundException("No message id given");
        } else {
            return memberDao.getMember(memberId).orElseThrow(NotFoundException::new);
        }
    }

    @PutMapping(value = "{memberId}")
    public boolean updateMember(@RequestBody Member member, @PathVariable Long memberId)
            throws NotFoundException {
        if (memberId == 0 || memberDao.getMember(memberId) == null) {
            throw new NotFoundException("No member with id " + memberId);
        }
        return memberDao.updateMember(member);
    }

    @DeleteMapping("{memberId}")
    public boolean deleteMember(@PathVariable long memberId) throws NotFoundException {
        if (memberId == 0) {
            throw new NotFoundException("No message id given");
        } else {
            final Member member = memberDao.getMember(memberId).orElseThrow(NotFoundException::new);
            member.setStatus(5);
            return memberDao.updateMember(member);
        }
    }

    @GetMapping("{memberId}/roles")
    public List<Role_> getMemberRoles(@PathVariable Long memberId) {
        if (memberId == null) {
            return new ArrayList<>();
        } else {
            return this.roleService.getMemberRoles(memberId);
        }
    }

    @GetMapping("count")
    public Integer countMembers(
            @RequestParam(required = false) String screenName,
            @RequestParam(required = false) String category) {
        return memberDao.countByGiven(screenName, category);
    }

    @PostMapping
    public Member register(@RequestBody Member member) {
        return memberService.register(member.getScreenName(), member.getHashedPassword(),
                member.getEmailAddress(), member.getFirstName(), member.getLastName(),
                member.getShortBio(), member.getCountry(), member.getFacebookId(),
                member.getOpenId(), member.getPortraitFileEntryId(), member.getId_());
    }

    @PostMapping("registerFromSharedColab")
    public Member registerFromSharedColab(@RequestBody Member member) throws NoSuchAlgorithmException {
            return memberService.registerWithHashedPassword(member.getScreenName(), member.getHashedPassword(),
                    member.getEmailAddress(), member.getFirstName(), member.getLastName(),
                    member.getShortBio(), member.getCountry(), member.getFacebookId(),
                    member.getOpenId(), member.getPortraitFileEntryId(), member.getId_());
    }





    @GetMapping("{memberId}/activityCount")
    public int getMemberActivityCount(@PathVariable Long memberId) {
        if (memberId == null) {
            return 0;
        } else {
            Integer ret = memberDao.getMemberActivityCount(memberId);
            return ((ret == null) ? (0) : (ret));
        }
    }

    @GetMapping("{memberId}/materializedPoints")
    public int getMemberMaterializedPoints(@PathVariable Long memberId) {
        if (memberId == null) {
            return 0;
        } else {
            Integer ret = memberDao.getMemberMaterializedPoints(memberId);
            return ((ret == null) ? (0) : (ret));
        }
    }

    @PutMapping("{memberId}/subscribe")
    public boolean subscribe(@PathVariable long memberId) throws NotFoundException {
        return memberService.subscribeToNewsletter(memberId);
    }

    @PutMapping("{memberId}/unsubscribe")
    public boolean unsubscribe(@PathVariable long memberId) throws NotFoundException {
        return memberService.unsubscribeFromNewsletter(memberId);
    }

    @GetMapping("{memberId}/isSubscribed")
    public boolean isSubscribed(@PathVariable long memberId) throws IOException, NotFoundException {
        return memberService.isSubscribedToNewsletter(memberId);
    }

    @GetMapping("{memberId}/contestRoles")
    public List<Role_> getMemberRoles(@PathVariable long memberId,
                                      @RequestParam long contestId) {
        return this.roleService.getMemberRolesInContest(memberId, contestId);
    }
}

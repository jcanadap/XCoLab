package org.xcolab.view.pages.contestmanagement.utils;

import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.members.PermissionsClient;
import org.xcolab.view.auth.MemberAuthUtil;
import org.xcolab.view.taglibs.xcolab.interfaces.TabPermissions;
import org.xcolab.view.util.entity.enums.MemberRole;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class ContestPermissions implements TabPermissions, Serializable {

    private final Contest contestWrapper;

    private final long memberId;
    private final boolean isLoggedIn;

    public ContestPermissions(HttpServletRequest request, Contest contest) {

        memberId = MemberAuthUtil.getMemberId(request);
        isLoggedIn = memberId > 0;
        contestWrapper = (contest);
    }

    @Override
    public boolean getCanAdmin() {
        return PermissionsClient.canAdminAll(memberId);
    }

    @Override
    public boolean getCanRole(MemberRole role) {
        return isLoggedIn && contestWrapper
                .getHasUserRoleInContest(memberId, role.getRoleId());
    }

    @Override
    public boolean getCanDelete() {
        return isLoggedIn;
    }

    @Override
    public boolean getCanCreate() {
        return isLoggedIn;
    }

    public boolean getCanEdit() {
        return isLoggedIn;
    }

    public boolean getCanAdminAll() {
        return PermissionsClient.canAdminAll(memberId);
    }
}

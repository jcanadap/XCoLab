package org.xcolab.portlets.contestmanagement.utils;

import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.PermissionsClient;
import org.xcolab.entity.utils.members.MemberAuthUtil;
import org.xcolab.enums.MemberRole;
import org.xcolab.interfaces.TabPermissions;

import javax.portlet.PortletRequest;

public class ContestManagementPermissions implements TabPermissions {
    private final boolean isLoggedIn;
    private final long memberId;

    public ContestManagementPermissions(PortletRequest request) {
        memberId = MemberAuthUtil.getMemberId(request);
        isLoggedIn = memberId > 0;
    }

    @Override
    public boolean getCanRole(MemberRole role) {
        if (!isLoggedIn) {
            return false;
        }

        return MembersClient.hasMemberRole(memberId, role.getRoleId());
    }

    @Override
    public boolean getIsOwner() {
        // TODO check who needs this
        return false;
    }

    @Override
    public boolean getCanAdmin() {
        return PermissionsClient.canAdminAll(memberId);
    }

    @Override
    public boolean getCanStaff() {
        if (!isLoggedIn) {
            return false;
        }
        return MembersClient.hasMemberRole(memberId, MemberRole.STAFF.getRoleId());
    }

    public boolean getCanEdit() {
        // TODO check who needs this
        return isLoggedIn;
    }

    @Override
    public boolean getCanDelete() {
        return isLoggedIn;
    }

    @Override
    public boolean getCanCreate() {
        // TODO check who needs this
        return isLoggedIn;
    }

    public boolean getCanAdminAll() {
        return PermissionsClient.canAdminAll(memberId);
    }
}

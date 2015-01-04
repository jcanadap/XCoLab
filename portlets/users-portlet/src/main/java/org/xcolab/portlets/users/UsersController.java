package org.xcolab.portlets.users;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.Cookie;

import com.ext.portlet.model.User_;
import com.ext.portlet.service.User_LocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xcolab.commons.beans.SortFilterPage;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.ext.portlet.Activity.ActivityUtil;
import org.xcolab.portlets.users.utils.UserItem;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("view")
public class UsersController {

    private int USERS_PER_PAGE = 20;

    @RequestMapping
    public String showUsers(PortletRequest request, PortletResponse response, SortFilterPage sortFilterPage, @RequestParam(value = "page", required = false) Long pageParam, Model model) throws SystemException, PortalException {

        //Pagination

        int page=1;
        if (pageParam!=null)
            page = pageParam.intValue();

        int usersCount = UserLocalServiceUtil.getUsersCount();
        int pagesCount = usersCount / USERS_PER_PAGE;
        int startPage = page - 5 > 0?page - 5:1;
        int endPage = startPage + 10<pagesCount? startPage+10:pagesCount;


        int firstUser = 1;
        if (page > 1)
            firstUser = ((page-1) * USERS_PER_PAGE)+1;

        int endUser = (firstUser+USERS_PER_PAGE)-1;

        //List<User> liferayUsers = UserLocalServiceUtil.getUsers(firstUser,endUser);

        List<User_> dBUsers = null;
        if (sortFilterPage.getSortColumn()!=null)
        switch (sortFilterPage.getSortColumn())
        {
            case "USER_NAME":
                if (sortFilterPage.isSortAscending())
                    dBUsers = User_LocalServiceUtil.getUsersSortedByScreenNameAsc(firstUser,endUser);
                else
                    dBUsers = User_LocalServiceUtil.getUsersSortedByScreenNameDesc(firstUser,endUser);
            break;

            case "ACTIVITY":
                if (sortFilterPage.isSortAscending())
                    dBUsers = User_LocalServiceUtil.getUsersSortedByActivityCountAsc(firstUser,endUser);
                else
                    dBUsers = User_LocalServiceUtil.getUsersSortedByActivityCountDesc(firstUser,endUser);
                break;

            case "CATEGORY":
                if (sortFilterPage.isSortAscending())
                    dBUsers = User_LocalServiceUtil.getUsersSortedByRoleNameAsc(firstUser,endUser);
                else
                    dBUsers = User_LocalServiceUtil.getUsersSortedByRoleNameDesc(firstUser,endUser);
                break;

            case "MEMBER_SINCE":
                if (sortFilterPage.isSortAscending())
                    dBUsers = User_LocalServiceUtil.getUsersSortedByMemberSinceAsc(firstUser,endUser);
                else
                    dBUsers = User_LocalServiceUtil.getUsersSortedByMemberSinceDesc(firstUser,endUser);
                break;
        }
        else {
            dBUsers = User_LocalServiceUtil.getUsersSortedByScreenNameAsc(firstUser, endUser);
            sortFilterPage.setSortColumn("USER_NAME");
            sortFilterPage.setSortAscending(true);
        }

        List<UserItem> users = new ArrayList<UserItem>();
        for (User_ user : dBUsers)
        {
            UserItem userItem = new UserItem(user);
            users.add(userItem);
        }

        model.addAttribute("pageNumber", page);
        model.addAttribute("pagesCount", pagesCount);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("sortFilterPage", sortFilterPage);
        model.addAttribute("users", users);
        model.addAttribute("usersCount", usersCount);

        return "users";

    }

}
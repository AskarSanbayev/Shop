package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;

import javax.servlet.http.HttpServletRequest;

public class ToUserMenuCommand implements Command {
    public static final String TO_USER_PAGE = "to_userpage";

    @Override
    public String execute(HttpServletRequest request) {
        String toLogin = request.getParameter(TO_USER_PAGE);
        request.setAttribute(TO_USER_PAGE, toLogin);
        return PageContainer.USER_MENU_PAGE;
    }
}

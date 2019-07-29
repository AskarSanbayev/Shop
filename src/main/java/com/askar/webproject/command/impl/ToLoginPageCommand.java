package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;

import javax.servlet.http.HttpServletRequest;

public class ToLoginPageCommand implements Command {

    public static final String TO_LOGIN = "to_login";

    @Override
    public String execute(HttpServletRequest request) {
        String toLogin = request.getParameter(TO_LOGIN);
        request.setAttribute(TO_LOGIN, toLogin);

        return PageContainer.LOGIN_PAGE;
    }
}

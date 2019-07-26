package com.web.project.command.commandimpl;

import com.web.project.command.Command;
import com.web.project.command.PageContainer;

import javax.servlet.http.HttpServletRequest;

public class LoginPage implements Command {

    public static final String TO_LOGIN = "to_Login";

    @Override
    public String execute(HttpServletRequest request) {
        String toLogin = request.getParameter(TO_LOGIN);
        request.setAttribute(TO_LOGIN, toLogin);

        return PageContainer.LOGIN_PAGE;
    }
}

package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;

import javax.servlet.http.HttpServletRequest;

public class ToRegisterPageCommand implements Command {

    public static final String TO_REGISTER = "to_Register";

    @Override
    public String execute(HttpServletRequest request) {
        String toRegister = request.getParameter(TO_REGISTER);
        request.setAttribute(TO_REGISTER, toRegister);

        return PageContainer.REGISTER_PAGE;
    }
}

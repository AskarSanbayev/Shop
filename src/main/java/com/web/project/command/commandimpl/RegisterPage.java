package com.web.project.command.commandimpl;

import com.web.project.command.Command;
import com.web.project.command.PageContainer;

import javax.servlet.http.HttpServletRequest;

public class RegisterPage implements Command {

    public static final String TO_REGISTER = "to_Register";

    @Override
    public String execute(HttpServletRequest request) {
        String toRegister = request.getParameter(TO_REGISTER);
        request.setAttribute(TO_REGISTER, toRegister);

        return PageContainer.REGISTER_PAGE;
    }
}

package com.web.project.command.commandimpl;

import com.web.project.command.Command;

import javax.servlet.http.HttpServletRequest;

public class RegisterResultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String register_result = request.getParameter("register");
        request.setAttribute("register_result", register_result);

        return PageContainer.RESULT_REGISTER_PAGE;
    }
}

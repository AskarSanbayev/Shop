package com.web.project.command.commandimpl;

import com.web.project.command.Command;

import javax.servlet.http.HttpServletRequest;

public class SignUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String page = null;


        return page;
    }
}

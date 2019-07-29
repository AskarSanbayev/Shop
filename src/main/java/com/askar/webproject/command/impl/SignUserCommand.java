package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Account;
import com.askar.webproject.service.ServiceFactory;
import com.askar.webproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignUserCommand implements Command {
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        HttpSession session = request.getSession(true);

        String login = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        String page = null;
        Account account = null;

        try {
            account = userService.findAccount(login, password);
            request.setAttribute("user", account);
            session.setAttribute("user", account);
            session.setAttribute("name", account.getFirstName());
            session.setAttribute("lastname", account.getLastName());
            session.setAttribute("email", account.getEmail());
            session.setAttribute("accountbalance", account.getAccountBalance());
            session.setAttribute("password", account.getPassword());
            session.setAttribute("gender", account.getGender());
            session.setAttribute("birthdate", account.getDate());
            page = PageContainer.USER_MENU_PAGE;
        } catch (ServiceException e) {
            request.setAttribute("error", e);
            page = PageContainer.ERROR_PAGE;
        }

        return page;
    }
}

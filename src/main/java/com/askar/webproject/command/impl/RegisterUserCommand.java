package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Account;
import com.askar.webproject.service.ServiceFactory;
import com.askar.webproject.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegisterUserCommand implements Command {
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "lastname";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String MONTH = "month";
    private static final String DAY = "day";
    private static final String YEAR = "year";
    private static final String GENDER = "gender";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        Account account = null;
        String page = null;
        String name = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        int month = Integer.parseInt(request.getParameter(MONTH));
        int day = Integer.parseInt(request.getParameter(DAY));
        int year = Integer.parseInt(request.getParameter(YEAR));
        String gender = request.getParameter(GENDER);
        account = new Account(name, lastName, password, 0, email, year, month, day, gender);
        try {
            userService.create(account);
            request.setAttribute("user", account);
            page = PageContainer.RESULT_REGISTER_PAGE;
        } catch (ServiceException e) {
//            LOGGER.error("RegisterUserCommand error.", e);
            request.setAttribute("error", e);
            page = PageContainer.ERROR_PAGE;
        }
        return page;
    }
}

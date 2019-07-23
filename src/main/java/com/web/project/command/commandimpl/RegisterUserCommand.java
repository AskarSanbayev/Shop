package com.web.project.command.commandimpl;

import com.web.project.command.Command;
import com.web.project.dao.impl.AccountDaoImpl;
import com.web.project.model.entity.Account;

import javax.servlet.http.HttpServletRequest;

public class RegisterUserCommand implements Command {
    private AccountDaoImpl accountDao = new AccountDaoImpl();

    @Override
    public String execute(HttpServletRequest request) {
        Account account = null;
        String page = null;

        if (validate(request)) {
            request.setAttribute("errorString", "This email is already registered. Please try again.");
            page = PageContainer.REGISTER_PAGE;
        } else {
            String name = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int month = Integer.parseInt(request.getParameter("month"));
            int day = Integer.parseInt(request.getParameter("day"));
            int year = Integer.parseInt(request.getParameter("year"));
            String gender = request.getParameter("gender");
            account = new Account(name, lastname, password, email, year, month, day, gender);
//            accountDao.add(account);
            request.setAttribute("user", account);
            request.setAttribute("name", account.getFirstName());
            request.setAttribute("lastName", account.getLastName());
            request.getSession().setAttribute("user", account);
            page = PageContainer.RESULT_REGISTER_PAGE;
        }

        return page;
    }


    private boolean validate(HttpServletRequest request) {
        String email = request.getParameter("email");
        boolean find = false;
        find = accountDao.find(email);

        return find;
    }
}

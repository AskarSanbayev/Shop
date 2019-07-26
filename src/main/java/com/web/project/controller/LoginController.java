package com.web.project.controller;

import com.web.project.dao.impl.AccountDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private AccountDaoImpl accountDao = new AccountDaoImpl();
    private boolean find = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("Content-type: text/html");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        if (!find(req)) {
            out.print("<span style='color:red;'>Login or password is wrong</span>");
            accountDao.setAccountExists(false);
        } else {
            accountDao.setAccountExists(false);
        }
    }

    private boolean find(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        find = accountDao.logIn(email, password);
        return find;
    }
}

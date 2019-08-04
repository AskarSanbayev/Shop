package com.askar.webproject.controller.ajax;

import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Account;
import com.askar.webproject.service.ServiceFactory;
import com.askar.webproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginCheckController extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        PrintWriter out = resp.getWriter();
        resp.setContentType("Content-type: text/html");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Account account = null;
        try {
            account = userService.findAccount(email, password);
            if (account == null) {
                out.print("<span style='color:red;'>Login or password is wrong</span>");
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
    }
}

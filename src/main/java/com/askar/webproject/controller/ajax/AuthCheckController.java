package com.askar.webproject.controller.ajax;

import com.askar.webproject.dao.impl.AccountDaoImpl;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.service.ServiceFactory;
import com.askar.webproject.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/authServlet")
public class AuthCheckController extends HttpServlet {

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
        try {
            if (userService.findByEmail(email)) {
                out.print("<span style='color:red;'>Login unavailable</span>");
            } else {
                out.print("<span style='color:green;'>Login available</span>");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}

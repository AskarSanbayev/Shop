package com.askar.webproject.controller;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.CommandManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class FrontController extends HttpServlet {

    private static final String COMMAND = "command";
    private static final String PARAM_PAGE_PATH = "pagePath";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page;
        if (req.getParameterMap().containsKey(PARAM_PAGE_PATH)) {
            page = req.getParameter(PARAM_PAGE_PATH);
        } else {
            Command command = CommandManager.getInstance().getCommand(req.getParameter(COMMAND));
            page = command.execute(req);
        }
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath());
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}

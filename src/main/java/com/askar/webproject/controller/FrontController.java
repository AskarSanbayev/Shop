package com.askar.webproject.controller;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.CommandManager;

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
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGetRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processPostRequest(req, resp);
    }

    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        } else{
            resp.sendRedirect(req.getContextPath() + page);
        }
    }

    private void processPostRequest(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        String page;
        Command command = CommandManager.getInstance().getCommand(req.getParameter(COMMAND));
        page = command.execute(req);
        if (page != null) {
            resp.sendRedirect("controller?pagePath=" + page);
        } else{
            resp.sendRedirect(req.getContextPath() + page);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}

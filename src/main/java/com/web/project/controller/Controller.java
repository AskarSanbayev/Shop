package com.web.project.controller;

import com.web.project.command.Command;
import com.web.project.command.CommandManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static final String COMMAND = "command";

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(COMMAND);

        Command command = CommandManager.getInstance().getCommand(commandName);

        String page = command.execute(req);
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);

        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}

package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    private static final String EMPTY_COMMAND = "EmptyCommand";

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("error", EMPTY_COMMAND);
        return PageContainer.ERROR_PAGE;
    }
}

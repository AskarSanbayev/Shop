package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}

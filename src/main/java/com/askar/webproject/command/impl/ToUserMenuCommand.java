package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;

import javax.servlet.http.HttpServletRequest;

public class ToUserMenuCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PageContainer.USER_MENU_PAGE;
    }
}

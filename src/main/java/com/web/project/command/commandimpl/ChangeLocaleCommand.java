package com.web.project.command.commandimpl;

import com.web.project.command.Command;
import com.web.project.command.PageContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

public class ChangeLocaleCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String newLocalization = request.getParameter("localization");

        request.getSession().setAttribute("localization", newLocalization);
        Config.set(request.getSession(), Config.FMT_LOCALE, newLocalization);

        return PageContainer.INDEX_PAGE;
    }
}

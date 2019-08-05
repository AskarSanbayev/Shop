package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.service.OrderProductService;
import com.askar.webproject.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OrderProductService orderProductService = serviceFactory.getOrderProductService();
        int orderId = (int) request.getSession().getAttribute("order_id");
        try {
            orderProductService.delete(orderId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getSession().invalidate();
        return PageContainer.INDEX_PAGE;
    }
}

package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.service.OrderProductService;
import com.askar.webproject.service.OrderService;
import com.askar.webproject.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OrderProductService orderProductService = serviceFactory.getOrderProductService();
        OrderService orderService = serviceFactory.getOrderService();
        int orderId = (int) request.getSession().getAttribute("order_id");
        try {
            orderService.delete(orderId);
            orderProductService.delete(orderId);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        request.getSession().invalidate();
        return PageContainer.INDEX_PAGE;
    }
}
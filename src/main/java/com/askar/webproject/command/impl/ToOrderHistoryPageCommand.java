package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Order;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.OrderService;
import com.askar.webproject.service.ProductService;
import com.askar.webproject.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class ToOrderHistoryPageCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ProductService productService = serviceFactory.getProductService();
        OrderService orderService = serviceFactory.getOrderService();

        HttpSession session = request.getSession();

        Map<Order, Map<Product, Integer>> orderList = null;
        int accountId = (int) session.getAttribute("accountId");
        try {
            orderList = orderService.findAll(accountId, productService);
            session.setAttribute("orderhistory", orderList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return PageContainer.ORDER_HISTORY_PAGE;
    }
}

package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.OrderProductService;
import com.askar.webproject.service.OrderService;
import com.askar.webproject.service.ProductService;
import com.askar.webproject.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class DeleteOrderCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SESSION_ORDER_PRICE = "price";
    private static final String SESSION_ORDER_ID = "order_id";
    private static final String SESSION_PRODUCT_MAPPER = "product_map";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        OrderService orderService = serviceFactory.getOrderService();
        OrderProductService orderProductService = serviceFactory.getOrderProductService();

        HttpSession session = request.getSession();
        Map<Product, Integer> productAmountMap = (Map<Product, Integer>) session.getAttribute(SESSION_PRODUCT_MAPPER);
        int orderId = (int) session.getAttribute(SESSION_ORDER_ID);

        try {
            productAmountMap.clear();
            orderService.updatePrice(0, orderId);
            orderProductService.delete(orderId);
            session.setAttribute(SESSION_ORDER_PRICE, 0);
            session.setAttribute(SESSION_PRODUCT_MAPPER, productAmountMap);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return PageContainer.CART_PAGE;
    }
}

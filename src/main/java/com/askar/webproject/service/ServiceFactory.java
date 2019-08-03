package com.askar.webproject.service;

import com.askar.webproject.service.impl.OrderProductServiceImpl;
import com.askar.webproject.service.impl.OrderServiceImpl;
import com.askar.webproject.service.impl.ProductServiceImpl;
import com.askar.webproject.service.impl.UserServiceImpl;

public class ServiceFactory {
    private UserService userService = new UserServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private OrderProductService orderProductService = new OrderProductServiceImpl();

    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public OrderProductService getOrderProductService() {
        return orderProductService;
    }
}

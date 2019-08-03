package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Order;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.OrderService;
import com.askar.webproject.service.ProductService;
import com.askar.webproject.service.ServiceFactory;
import com.askar.webproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SendOrderCommand implements Command {

    private static final String SESSION_ORDER_PRICE = "price";
    private static final String SESSION_ORDER_ID = "order_id";
    private static final String SESSION_ORDER = "order";
    private static final String SESSION_ACCOUNT_BALANCE = "accountbalance";
    private static final String SESSION_PRODUCT_MAPPER = "product_map";
    private static final String SESSION_ACCOUNT_ID = "account_id";
    private static final String SESSION_ORDER_HISTORY = "order_history_list";

    @Override
    public String execute(HttpServletRequest request) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        HttpSession session = request.getSession();
        double price = (double) session.getAttribute(SESSION_ORDER_PRICE);
        double accountBalance = (double) session.getAttribute(SESSION_ACCOUNT_BALANCE);
        String email = (String) session.getAttribute("email");


        if (price > accountBalance) {
            String error = "You dont have enough money in your account";
            request.setAttribute("errormoney", error);
        } else {
            try {
                double balance = accountBalance - price;
                userService.setAccountBalance(email, balance);
                session.setAttribute(SESSION_ACCOUNT_BALANCE, balance);
                session.setAttribute(SESSION_ORDER, null);
                session.setAttribute(SESSION_ORDER_ID, null);
                session.setAttribute(SESSION_ORDER_PRICE, null);
                session.setAttribute(SESSION_PRODUCT_MAPPER, null);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }

        return PageContainer.CART_PAGE;
    }
}

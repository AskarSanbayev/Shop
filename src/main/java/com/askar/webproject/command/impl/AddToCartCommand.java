package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Order;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.OrderProductService;
import com.askar.webproject.service.OrderService;
import com.askar.webproject.service.ProductService;
import com.askar.webproject.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddToCartCommand implements Command {


    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PRODUCT_CODE = "code";
    private static final String PRODUCT_AMOUNT = "amount";
    private static final String SESSION_ORDER = "order";
    private static final String ACCOUNT_ID = "accountId";
    private static final String SESSION_ORDER_ID = "order_id";
    private static final String SESSION_ORDER_PRICE = "price";
    private static final String SESSION_PRODUCT_MAPPER = "product_map";


    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ProductService productService = serviceFactory.getProductService();
        OrderService orderService = serviceFactory.getOrderService();
        OrderProductService orderProductService = serviceFactory.getOrderProductService();
        HttpSession session = request.getSession();

        int code = Integer.parseInt(request.getParameter(PRODUCT_CODE));
        int amount = Integer.parseInt(request.getParameter(PRODUCT_AMOUNT));
        int accountId = (int) session.getAttribute(ACCOUNT_ID);
        Order order = (Order) session.getAttribute(SESSION_ORDER);
        double price;
        Product product;

        try {
            if (productService.findByCode(code) != null) {
                if (order == null) {
                    order = new Order();
                    product = productService.findByCode(code);
                    price = amount * productService.findPriceByCode(code);
                    order.setPrice(price);
                    order.setAccountId(accountId);
                    orderService.create(order);
                    order.addProduct(product, amount);
                    orderProductService.create(order.getOrderId(), code, amount);

                    session.setAttribute(SESSION_ORDER, order);
                    session.setAttribute(SESSION_ORDER_ID, order.getOrderId());
                    session.setAttribute(SESSION_ORDER_PRICE, order.getPrice());
                    session.setAttribute(SESSION_PRODUCT_MAPPER, order.getProducts());
                } else {
                    price = (double) session.getAttribute(SESSION_ORDER_PRICE);
                    product = productService.findByCode(code);
                    price = amount * productService.findPriceByCode(code) + price;
                    order.addProduct(product, amount);
                    order.setPrice(price);
                    orderService.updatePrice(price, order.getOrderId());
                    if (orderProductService.findByCode(order.getOrderId(), code)) {
                        orderProductService.updateAmount(order.getOrderId(), code, amount);
                    } else {
                        orderProductService.create(order.getOrderId(), code, amount);
                    }
                    session.setAttribute(SESSION_ORDER, order);
                    session.setAttribute(SESSION_ORDER_ID, order.getOrderId());
                    session.setAttribute(SESSION_ORDER_PRICE, order.getPrice());
                    session.setAttribute(SESSION_PRODUCT_MAPPER, order.getProducts());
                }
            } else {
                String errormessage = "Wrong product code";
                request.setAttribute("errormessage", errormessage);
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return PageContainer.USER_MENU_PAGE;
    }

}

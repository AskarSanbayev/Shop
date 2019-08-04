package com.askar.webproject.command.impl;

import com.askar.webproject.command.Command;
import com.askar.webproject.command.PageContainer;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.OrderProductService;
import com.askar.webproject.service.OrderService;
import com.askar.webproject.service.ProductService;
import com.askar.webproject.service.ServiceFactory;
import com.askar.webproject.service.impl.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class RemoveFromCartCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PRODUCT_CODE = "code";
    private static final String SESSION_ORDER_PRICE = "price";
    private static final String SESSION_ORDER_ID = "order_id";
    private static final String SESSION_PRODUCT_MAPPER = "product_map";

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ProductService productService = serviceFactory.getProductService();
        OrderProductService orderProductService = serviceFactory.getOrderProductService();
        OrderService orderService = new OrderServiceImpl();

        HttpSession session = request.getSession();
        Map<Product, Integer> productAmountMap = (Map<Product, Integer>) session.getAttribute(SESSION_PRODUCT_MAPPER);

        double price = (double) session.getAttribute(SESSION_ORDER_PRICE);
        int orderId = (int) session.getAttribute(SESSION_ORDER_ID);
        int code = Integer.parseInt(request.getParameter(PRODUCT_CODE));

        try {
            Product product = productService.findByCode(code);
            if (productAmountMap.containsKey(product)) {
                double productPrice = product.getPrice() * productAmountMap.get(product);
                price = price - productPrice;
                orderService.updatePrice(price, orderId);
                productAmountMap.remove(product);
                orderProductService.delete(orderId, code);
                session.setAttribute(SESSION_ORDER_PRICE, price);
                session.setAttribute(SESSION_PRODUCT_MAPPER, productAmountMap);
            } else {
                String error = "wrong product code";
                request.setAttribute("error", error);
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return PageContainer.CART_PAGE;
    }
}

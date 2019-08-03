package com.askar.webproject.dao;

import com.askar.webproject.dao.impl.AccountDaoImpl;
import com.askar.webproject.dao.impl.OrderDaoImpl;
import com.askar.webproject.dao.impl.OrderProductDaoImpl;
import com.askar.webproject.dao.impl.ProductDaoImpl;

public class DAOFactory {

    private AccountDao accountDao = new AccountDaoImpl();

    private ProductDao productDao = new ProductDaoImpl();

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderProductDao orderProductDao = new OrderProductDaoImpl();

    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public OrderProductDao getOrderProductDao() {
        return orderProductDao;
    }
}

package com.askar.webproject.dao;

import com.askar.webproject.dao.impl.AccountDaoImpl;
import com.askar.webproject.dao.impl.ProductDaoImpl;

public class DAOFactory {

    private AccountDao accountDao = new AccountDaoImpl();

    private ProductDao productDao = new ProductDaoImpl();

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
}

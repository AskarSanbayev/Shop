package com.askar.webproject.service.impl;

import com.askar.webproject.dao.DAOFactory;
import com.askar.webproject.dao.OrderDao;
import com.askar.webproject.exception.DaoException;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Entity;
import com.askar.webproject.model.entity.Order;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.OrderService;
import com.askar.webproject.service.ProductService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private OrderDao orderDao = daoFactory.getOrderDao();

    @Override
    public void create(Entity entity) throws ServiceException {
        if (entity != null) {
            try {
                orderDao.create(entity);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void updatePrice(double price, int orderId) throws ServiceException {
        if (price >= 0) {
            try {
                orderDao.updatePrice(price, orderId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void delete(int orderId) throws ServiceException {
        if (orderId > 0) {
            try {
                orderDao.delete(orderId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }

    }

    @Override
    public Map<Order, Map<Product, Integer>> findAll(int accountId, ProductService productService) throws ServiceException {
        Map<Order, Map<Product, Integer>> orderList;
        try {
            orderList = orderDao.findAll(accountId, productService);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return orderList;
    }


    @Override
    public void update(Entity entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Entity entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}

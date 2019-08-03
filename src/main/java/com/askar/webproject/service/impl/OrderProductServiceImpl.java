package com.askar.webproject.service.impl;

import com.askar.webproject.dao.DAOFactory;
import com.askar.webproject.dao.OrderProductDao;
import com.askar.webproject.exception.DaoException;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Entity;
import com.askar.webproject.service.OrderProductService;

public class OrderProductServiceImpl implements OrderProductService {
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private OrderProductDao orderProductDao = daoFactory.getOrderProductDao();

    @Override
    public void create(int orderId, int productCode, int amount) throws ServiceException {
        if (amount > 0) {
            try {
                orderProductDao.create(orderId, productCode, amount);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void delete(int orderId, int code) throws ServiceException {
        try {
            orderProductDao.delete(orderId, code);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int orderId) throws ServiceException {
        try {
            orderProductDao.delete(orderId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean findByCode(int orderId, int code) throws ServiceException {
        boolean find = false;
        try {
            find = orderProductDao.findByCode(orderId, code);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return find;
    }

    @Override
    public void updateAmount(int orderId, int code, int amount) throws ServiceException {
        if (amount > 0) {
            try {
                orderProductDao.updateAmount(orderId, code, amount);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void create(Entity entity) throws ServiceException {
        throw new UnsupportedOperationException();
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

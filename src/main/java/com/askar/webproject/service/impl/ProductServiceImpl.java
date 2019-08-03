package com.askar.webproject.service.impl;

import com.askar.webproject.dao.DAOFactory;
import com.askar.webproject.dao.ProductDao;
import com.askar.webproject.exception.DaoException;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Entity;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private ProductDao productDao = daoFactory.getProductDao();


    @Override
    public double findPriceByCode(int code) throws ServiceException {
        double price = 0;
        if (code > 0) {
            try {
                price = productDao.findPriceByCode(code);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
        return price;
    }

    @Override
    public Product findByCode(int code) throws ServiceException {
        Product product;
        if (code > 0) {
            try {
                product = productDao.findByCode(code);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
            return product;
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void updatePrice(double price, int code) throws ServiceException {
        if (price > 0 && code > 0) {
            try {
                productDao.updatePrice(price, code);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public List<Product> findAll() throws ServiceException {
        List<Product> list = null;
        try {
            list = productDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void create(Entity entity) throws ServiceException {
        if (entity != null) {
            try {
                productDao.create(entity);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void delete(Entity entity) throws ServiceException {
        if (entity != null) {
            try {
                productDao.delete(entity);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void update(Entity entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}

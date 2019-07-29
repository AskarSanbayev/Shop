package com.askar.webproject.service.impl;

import com.askar.webproject.exception.DaoException;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Entity;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public boolean findByCode(int code) throws DaoException {
        return false;
    }

    @Override
    public void updatePrice(double price, int code) throws DaoException {

    }

    @Override
    public List<Product> findAll() throws DaoException {
        return null;
    }

    @Override
    public void create(Entity entity) throws ServiceException {

    }

    @Override
    public void update(Entity entity) throws ServiceException {

    }

    @Override
    public void delete(Entity entity) throws ServiceException {

    }
}

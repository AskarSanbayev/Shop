package com.askar.webproject.service;

import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Product;

import java.util.List;

public interface ProductService extends EntityService {
    boolean findByCode(int code) throws DaoException;

    void updatePrice(double price, int code) throws DaoException;

    List<Product> findAll() throws DaoException;
}

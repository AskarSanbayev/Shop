package com.askar.webproject.dao;

import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Product;

import java.util.List;

public interface ProductDao extends EntityDao {

    double findPriceByCode(int code) throws DaoException;

    Product findByCode(int code) throws DaoException;

    void updatePrice(double price, int code) throws DaoException;

    List<Product> findAll() throws DaoException;

}

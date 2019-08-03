package com.askar.webproject.service;

import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Product;

import java.util.List;

public interface ProductService extends EntityService {

    double findPriceByCode(int code) throws ServiceException;

    Product findByCode(int code) throws ServiceException;

    void updatePrice(double price, int code) throws ServiceException;

    List<Product> findAll() throws ServiceException;
}

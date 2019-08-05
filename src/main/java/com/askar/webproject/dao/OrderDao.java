package com.askar.webproject.dao;

import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Order;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.ProductService;

import java.util.Map;

public interface OrderDao extends EntityDao {
    void updatePrice(double price, int orderId) throws DaoException;

    void delete(int orderId) throws DaoException;

    Map<Order, Map<Product, Integer>> findAll(int accountId, ProductDao productDao) throws DaoException;
}

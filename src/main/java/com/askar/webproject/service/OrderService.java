package com.askar.webproject.service;

import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Order;
import com.askar.webproject.model.entity.Product;

import java.util.Map;

public interface OrderService extends EntityService {

    void updatePrice(double price, int orderId) throws ServiceException;

    void delete(int orderId) throws ServiceException;

    Map<Order, Map<Product, Integer>> findAll(int accountId, ProductService productService) throws ServiceException;
}

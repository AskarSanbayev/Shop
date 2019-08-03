package com.askar.webproject.service;

import com.askar.webproject.exception.ServiceException;

public interface OrderProductService extends EntityService {
    void create(int orderId, int productCode, int amount) throws ServiceException;

    void delete(int orderId, int code) throws ServiceException;

    void delete(int orderId) throws ServiceException;

    boolean findByCode(int orderId, int code) throws ServiceException;

    void updateAmount(int orderId, int code, int amount) throws ServiceException;
}

package com.askar.webproject.dao;

import com.askar.webproject.exception.DaoException;

public interface OrderProductDao extends EntityDao {

    void create(int orderId, int productCode, int amount) throws DaoException;

    void delete(int orderId, int code) throws DaoException;

    void delete(int orderId) throws DaoException;

    boolean findByCode(int orderId, int code) throws DaoException;

    void updateAmount(int orderId, int code, int amount) throws DaoException;
}

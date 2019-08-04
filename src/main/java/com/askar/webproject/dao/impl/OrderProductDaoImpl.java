package com.askar.webproject.dao.impl;

import com.askar.webproject.dao.OrderProductDao;
import com.askar.webproject.dao.connection.ConnectionPool;
import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderProductDaoImpl implements OrderProductDao {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String INSERT_PRODUCT = "INSERT INTO order_product (order_id,code,amount) values(?,?,?)";
    private static final String DELETE_ORDER = "DELETE FROM order_product WHERE order_id = ? and code = ?";
    private static final String DELETE_ORDER_BY_ID = "DELETE FROM order_product WHERE order_id = ?";
    private static final String UPDATE_AMOUNT = "UPDATE order_product set amount = (select amount Where order_id = ? and code = ?) + ? Where order_id = ? and code = ?";
    private static final String SELECT_BY_ORDER_CODE = "Select * from order_product where order_id = ? and code=?";

    @Override
    public void create(Entity entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Entity entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Entity entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(int orderId, int productCode, int amount) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(INSERT_PRODUCT);
            ps.setInt(1, orderId);
            ps.setInt(2, productCode);
            ps.setInt(3, amount);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int orderId, int code) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(DELETE_ORDER);
            ps.setInt(1, orderId);
            ps.setInt(2, code);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int orderId) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(DELETE_ORDER_BY_ID);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        }
    }

    @Override
    public boolean findByCode(int orderId, int code) throws DaoException {
        boolean find = false;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(SELECT_BY_ORDER_CODE);
            ps.setInt(1, orderId);
            ps.setInt(2, code);
            rs = ps.executeQuery();
            if (rs.first()) {
                find = true;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return find;
    }

    @Override
    public void updateAmount(int orderId, int code, int amount) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(UPDATE_AMOUNT);
            ps.setInt(1, orderId);
            ps.setInt(2, code);
            ps.setInt(3, amount);
            ps.setInt(4, orderId);
            ps.setInt(5, code);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        }
    }
}

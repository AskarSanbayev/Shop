package com.askar.webproject.dao.impl;

import com.askar.webproject.dao.ProductDao;
import com.askar.webproject.dao.connection.ConnectionPool;
import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Entity;
import com.askar.webproject.model.entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SELECT_BY_CODE = "Select * from product where code = ?";
    private static final String UPDATE_PRICE = "Update product set price = ? where code = ?";
    private static final String SELECT_ALL = "Select * from product";
    private static final String INSERT_PRODUCT = "INSERT INTO product(code,name,price) values(?,?,?)";
    private static final String DELETE_PRODUCT = "Delete from product where code = ?,name= ?,price =?";
    private static final String SELECT_PRICE_BY_CODE = "SELECT price from product where code = ?";

    private static final String PRODUCT_CODE = "code";
    private static final String PRODUCT_NAME = "name";
    private static final String PRODUCT_PRICE = "price";

    @Override
    public double findPriceByCode(int code) throws DaoException {
        double price = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(SELECT_PRICE_BY_CODE);
            ps.setInt(1, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                price = rs.getDouble(PRODUCT_PRICE);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException("product findByCode exception");
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
        return price;
    }

    @Override
    public Product findByCode(int code) throws DaoException {
        Product product = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(SELECT_BY_CODE);
            ps.setInt(1, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setCode(rs.getInt(PRODUCT_CODE));
                product.setName(rs.getString(PRODUCT_NAME));
                product.setPrice(rs.getDouble(PRODUCT_PRICE));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException("product findByCode exception");
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
        return product;
    }

    @Override
    public void updatePrice(double price, int code) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(UPDATE_PRICE);
            ps.setDouble(1, price);
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
    public List<Product> findAll() throws DaoException {
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Product product = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setCode(rs.getInt(PRODUCT_CODE));
                product.setName(rs.getString(PRODUCT_NAME));
                product.setPrice(rs.getDouble(PRODUCT_PRICE));
                products.add(product);
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

        return products;
    }

    @Override
    public void create(Entity entity) throws DaoException {
        if (entity instanceof Product) {
            Product product = (Product) entity;
            Connection connection = null;
            PreparedStatement ps = null;
            try {
                connection = ConnectionPool.INSTANCE.takeConnection();
                ps = connection.prepareStatement(INSERT_PRODUCT);
                ps.setInt(1, product.getCode());
                ps.setString(2, product.getName());
                ps.setDouble(3, product.getPrice());
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

    @Override
    public void update(Entity entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Entity entity) throws DaoException {
        if (entity instanceof Product) {
            Product product = (Product) entity;
            Connection connection = null;
            PreparedStatement ps = null;
            try {
                connection = ConnectionPool.INSTANCE.takeConnection();
                ps = connection.prepareStatement(DELETE_PRODUCT);
                ps.setInt(1, product.getCode());
                ps.setString(2, product.getName());
                ps.setDouble(3, product.getPrice());
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
}

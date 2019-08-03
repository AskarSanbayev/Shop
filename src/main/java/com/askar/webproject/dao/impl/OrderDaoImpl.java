package com.askar.webproject.dao.impl;

import com.askar.webproject.dao.OrderDao;
import com.askar.webproject.dao.connection.ConnectionPool;
import com.askar.webproject.exception.DaoException;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Entity;
import com.askar.webproject.model.entity.Order;
import com.askar.webproject.model.entity.Product;
import com.askar.webproject.service.ProductService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    private static final String INSERT_ORDER = "Insert into orders(order_id,price,account_id) values(?,?,?)";
    private static final String DELETE_ORDER = "Delete From orders where orderId = ?";
    private static final String UPDATE_PRICE = "UPDATE orders SET price=? WHERE order_id=?";
    private static final String SELECT_ALL_ORDERS = "Select orders.order_id,price,code,amount from orders inner join order_product on orders.order_id = order_product.order_id where account_id = ?";


    @Override
    public void create(Entity entity) throws DaoException {
        Order order = null;
        if (entity instanceof Order) {
            order = (Order) entity;
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                connection = ConnectionPool.INSTANCE.takeConnection();
                ps = connection.prepareStatement(INSERT_ORDER);
                ps.setInt(1, order.getOrderId());
                ps.setDouble(2, order.getPrice());
                ps.setInt(3, order.getAccountId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DaoException();
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
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
        throw new UnsupportedOperationException();
    }


    public void delete(int orderId) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(DELETE_ORDER);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        }
    }

    @Override
    public Map<Order, Map<Product, Integer>> findAll(int accountId, ProductService productService) throws DaoException {
        Map<Order, Map<Product, Integer>> orderList = new HashMap<>();
        Map<Product, Integer> productAmountMap = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order order = null;
        Product product = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(SELECT_ALL_ORDERS);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new Order();
                product = productService.findByCode(rs.getInt("code"));
                order.setOrderId(rs.getInt("order_id"));
                order.setPrice(rs.getDouble("price"));
                order.setAccountId(accountId);
                if (orderList.containsKey(order)) {
                    productAmountMap = orderList.get(order);
                    productAmountMap.put(product, rs.getInt("amount"));
                } else {
                    productAmountMap = new HashMap<>();
                    productAmountMap.put(product, rs.getInt("amount"));
                    orderList.put(order, productAmountMap);
                }
            }
        } catch (SQLException | ServiceException e) {
            e.printStackTrace();
            throw new DaoException();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return orderList;
    }

    @Override
    public void updatePrice(double price, int orderId) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(UPDATE_PRICE);
            ps.setDouble(1, price);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        }
    }
}

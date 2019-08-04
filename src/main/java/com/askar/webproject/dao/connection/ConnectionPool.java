package com.askar.webproject.dao.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public enum ConnectionPool {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger();
    private BlockingQueue<ProxyConnection> availableConnections;
    private List<ProxyConnection> givenConnections;
    private final String driverName = DatabaseManager.getValue(DatabaseManager.JDBC_MYSQL_DRIVER);
    private final String url = DatabaseManager.getValue(DatabaseManager.DATABASE_URL);
    private final String user = DatabaseManager.getValue(DatabaseManager.DATABASE_USER);
    private final String password = DatabaseManager.getValue(DatabaseManager.DATABASE_PASSWORD);
    private int poolSize;
    private static final int DEFAULT_POOL_SIZE = 8;

    ConnectionPool() {
        try {
            poolSize = Integer.parseInt(DatabaseManager.getValue(DatabaseManager.CONNECTION_COUNT));
        } catch (NumberFormatException e) {
            poolSize = DEFAULT_POOL_SIZE;
        }
        init();
    }

    private void init() {
        try {
            Class.forName(driverName);
            availableConnections = new ArrayBlockingQueue<>(poolSize);
            givenConnections = new ArrayList<>(poolSize);
        } catch (ClassNotFoundException e) {
            LOGGER.fatal(e);
        }
        for (int i = 0; i < poolSize; i++) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                LOGGER.fatal(e);
            }
            ProxyConnection proxyConnection = new ProxyConnection(connection);
            availableConnections.add(proxyConnection);
        }
    }

    public Connection takeConnection() {
        ProxyConnection connection = null;
        try {
            connection = availableConnections.take();
            givenConnections.add(connection);
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection instanceof ProxyConnection) {
            givenConnections.remove(connection);
            availableConnections.add((ProxyConnection) connection);
        }
    }

    public void destroyPool() {
        for (int i = 0; i < poolSize; i++) {
            try {
                availableConnections.take().realClose();
            } catch (SQLException | InterruptedException e) {
                LOGGER.error(e);
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        });
    }

}

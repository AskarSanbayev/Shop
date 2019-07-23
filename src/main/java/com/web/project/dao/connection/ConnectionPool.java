package com.web.project.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public enum ConnectionPool {
    INSTANCE;


    private BlockingQueue<ProxyConnection> availableConnections;
    private BlockingQueue<ProxyConnection> givenConnections;
    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;


    ConnectionPool() {
        this.driverName = DatabaseManager.getValue(DatabaseManager.JDBC_MYSQL_DRIVER);
        this.url = DatabaseManager.getValue(DatabaseManager.DATABASE_URL);
        this.user = DatabaseManager.getValue(DatabaseManager.DATABASE_USER);
        this.password = DatabaseManager.getValue(DatabaseManager.DATABASE_PASSWORD);
        this.poolSize = Integer.parseInt(DatabaseManager.getValue(DatabaseManager.CONNECTION_COUNT));
        init();
    }

    private void init() {

        try {
            Class.forName(driverName);
            availableConnections = new ArrayBlockingQueue<>(poolSize);
            givenConnections = new ArrayBlockingQueue<>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                availableConnections.add(proxyConnection);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public Connection takeConnection() {

        ProxyConnection connection = null;
        try {
            connection = availableConnections.take();
            givenConnections.put(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return connection;
    }

    public void releaseConnection(Connection connection) {

        if (connection instanceof ProxyConnection) {
            try {
                connection.setAutoCommit(true);
                givenConnections.remove(connection);
                availableConnections.add((ProxyConnection) connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void destroyPool() {
        int poolSize = availableConnections.size();

        for (int i = 0; i < poolSize; i++) {
            try {
                availableConnections.take().realClose();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

}

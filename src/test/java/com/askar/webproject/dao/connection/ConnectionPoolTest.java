package com.askar.webproject.dao.connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.TestCase.*;


public class ConnectionPoolTest {
    private Connection connection = null;

    @Test
    public void testGetInstance() {
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            boolean expected = true;
            boolean actual = connection.isValid(1);
            assertEquals(actual, expected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTakeConnection() {
        connection = ConnectionPool.INSTANCE.takeConnection();
        assertNotNull(connection);
    }
}

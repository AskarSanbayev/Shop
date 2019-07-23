package com.web.project.dao.impl;

import com.web.project.dao.AccountDao;
import com.web.project.dao.connection.ConnectionPool;
import com.web.project.model.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {

    private static final String INSERT_ACCOUNT = "INSERT INTO accounts (first_name,last_name,email,password,gender,birthday ) VALUES (?,?,?,?,?,?);";
    private static final String SELECT_ACCOUNT = "Select email From accounts where email = ?";
    private ConnectionPool connectionPool = ConnectionPool.INSTANCE;
    private Connection connection;

    private boolean accountExists = false;

    @Override
    public boolean find(String email) {
        connection = connectionPool.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                accountExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return accountExists;
    }

    @Override
    public void add(Account account) {
        connection = connectionPool.takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, account.getFirstName());
            preparedStatement.setString(2, account.getLastName());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.setString(5, account.getGender());
            preparedStatement.setString(6, String.valueOf(account.getDate()));
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }


    }

    public void setAccountExists(boolean accountExists) {
        this.accountExists = accountExists;
    }
}

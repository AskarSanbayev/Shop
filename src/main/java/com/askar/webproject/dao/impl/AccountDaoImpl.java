package com.askar.webproject.dao.impl;

import com.askar.webproject.dao.AccountDao;
import com.askar.webproject.dao.connection.ConnectionPool;
import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Account;
import com.askar.webproject.model.entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AccountDaoImpl implements AccountDao {


    private static final String INSERT_ACCOUNT = "INSERT INTO accounts (first_name,last_name,email,balance,password,gender,birthday ) VALUES (?,?,?,?,?,?,?);";
    private static final String SELECT_ACCOUNT_BY_EMAIL_PASSWORD = "Select * From accounts where email = ? and password = ?";
    private static final String SELECT_ACCOUNT_BY_EMAIL = "Select email From accounts where email = ?";
    private static final String UPDATE_ACCOUNT_BALANCE = "Update accounts set balance = ? where email = ?";
    private static final String UPDATE_ACCOUNT_PASSWORD = "Update accounts set password = ? where email = ?";
    private static final String DELETE_ACCOUNT = "Delete From accounts where email = ?";

    @Override
    public boolean findByEmail(String email) throws DaoException {
        boolean accountFind = false;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(SELECT_ACCOUNT_BY_EMAIL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.first()) {
                accountFind = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("account findByEmail exception");
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
        return accountFind;
    }

    @Override
    public Account findAccount(String email, String password) throws DaoException {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(SELECT_ACCOUNT_BY_EMAIL_PASSWORD);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setFirstName(rs.getString("first_name"));
                account.setLastName(rs.getString("last_name"));
                account.setEmail(rs.getString("email"));
                account.setAccountBalance(rs.getDouble("balance"));
                account.setPassword(rs.getString("password"));
                account.setGender(rs.getString("gender"));
                account.setDate(LocalDate.parse(rs.getString("Birthday")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("account find exception");
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
        return account;
    }

    @Override
    public void setAccountBalance(String email, double balance) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(UPDATE_ACCOUNT_BALANCE);
            ps.setDouble(1, balance);
            ps.setString(2, email);
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
    public void updateAccountPassword(String email, String password) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(UPDATE_ACCOUNT_PASSWORD);
            ps.setString(1, password);
            ps.setString(2, email);
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
    public void deleteAccountByLogin(String email) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.INSTANCE.takeConnection();
            ps = connection.prepareStatement(DELETE_ACCOUNT);
            ps.setString(1, email);
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
    public void create(Entity entity) throws DaoException {

        if (entity instanceof Account) {
            Account account = (Account) entity;
            Connection connection = null;
            PreparedStatement ps = null;
            try {
                connection = ConnectionPool.INSTANCE.takeConnection();
                ps = connection.prepareStatement(INSERT_ACCOUNT);
                ps.setString(1, account.getFirstName());
                ps.setString(2, account.getLastName());
                ps.setString(3, account.getEmail());
                ps.setDouble(4, account.getAccountBalance());
                ps.setString(5, account.getPassword());
                ps.setString(6, account.getGender());
                ps.setString(7, String.valueOf(account.getDate()));
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
}

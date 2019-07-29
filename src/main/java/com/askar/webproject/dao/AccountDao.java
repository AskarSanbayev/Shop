package com.askar.webproject.dao;

import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Account;

public interface AccountDao extends EntityDao {

    boolean findByEmail(String email) throws DaoException;

    Account findAccount(String email, String password) throws DaoException;

    void setAccountBalance(String email, double balance) throws DaoException;

    void updateAccountPassword(String email, String password) throws DaoException;

    void deleteAccountByLogin(String email) throws DaoException;
}

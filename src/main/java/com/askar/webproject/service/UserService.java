package com.askar.webproject.service;

import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Account;

public interface UserService extends EntityService {

    Account findAccount(String email, String passwrod) throws ServiceException;

    boolean findByEmail(String email) throws ServiceException;

    void setAccountBalance(String email, double balance) throws ServiceException;

    void updateAccountPassword(String email, String password) throws ServiceException;

    void deleteAccountByLogin(String email) throws ServiceException;
}

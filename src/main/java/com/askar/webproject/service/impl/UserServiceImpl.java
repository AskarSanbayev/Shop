package com.askar.webproject.service.impl;

import com.askar.webproject.dao.AccountDao;
import com.askar.webproject.dao.DAOFactory;
import com.askar.webproject.exception.DaoException;
import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Account;
import com.askar.webproject.model.entity.Entity;
import com.askar.webproject.service.UserService;

public class UserServiceImpl implements UserService {
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private AccountDao accountDao = daoFactory.getAccountDao();


    @Override
    public Account findAccount(String email, String password) throws ServiceException {
        Account account = null;
        if (email != null && password != null) {
            try {
                account = accountDao.findAccount(email, password);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
            return account;
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public boolean findByEmail(String email) throws ServiceException {
        boolean find = false;
        if (email != null) {
            try {
                find = accountDao.findByEmail(email);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
            return find;
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void setAccountBalance(String email, double balance) throws ServiceException {
        if (email != null && balance > 0) {
            try {
                accountDao.setAccountBalance(email, balance);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void updateAccountPassword(String email, String password) throws ServiceException {
        if (email != null && password != null) {
            try {
                accountDao.updateAccountPassword(email, password);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void deleteAccountByLogin(String email) throws ServiceException {
        if (email != null) {
            try {
                accountDao.deleteAccountByLogin(email);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void create(Entity entity) throws ServiceException {
        if (entity != null) {
            try {
                accountDao.create(entity);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect params");
        }
    }

    @Override
    public void update(Entity entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Entity entity) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}

package com.askar.webproject.dao.impl;

import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccountDaoImplTest {
    AccountDaoImpl accountDao = null;
    Account account = null;
    String email = null;

    @Before
    public void setUp() throws Exception {
        accountDao = new AccountDaoImpl();
        email = "sanb@gmail.com";
        account = new Account("askar", "san", "123", 0, "sanb@gmail.com", 1935, 1, 1, "M");
    }

    @After
    public void tearDown() throws Exception {
        accountDao = null;
        account = null;
        email = null;
    }

    @Test
    public void create() {
        try {
            accountDao.create(account);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByEmail() {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = accountDao.findByEmail(email);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);
    }


    @Test
    public void setAccountBalance() {
        double expected = 200;
        double actual = 0;
        try {
            accountDao.setAccountBalance(account.getEmail(), 200);
            actual = accountDao.findAccount(account.getEmail(), account.getPassword()).getAccountBalance();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);
    }


}

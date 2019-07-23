package com.web.project.dao;

import com.web.project.model.entity.Account;

import java.sql.SQLException;

public interface AccountDao {

    boolean find(String email) throws SQLException;

    void add(Account account);
}

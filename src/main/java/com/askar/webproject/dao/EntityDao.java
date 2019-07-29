package com.askar.webproject.dao;

import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Entity;

public interface EntityDao {
    void create(Entity entity) throws DaoException;

    void update(Entity entity) throws DaoException;

    void delete(Entity entity) throws DaoException;
}

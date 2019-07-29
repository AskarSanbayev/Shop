package com.askar.webproject.service;

import com.askar.webproject.exception.ServiceException;
import com.askar.webproject.model.entity.Entity;

public interface EntityService {

    void create(Entity entity) throws ServiceException;

    void update(Entity entity) throws ServiceException;

    void delete(Entity entity) throws ServiceException;
}

package com.askar.webproject.dao.impl;

import com.askar.webproject.exception.DaoException;
import com.askar.webproject.model.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ProductDaoImplTest {

    ProductDaoImpl productDao = null;
    Product product = null;


    @Before
    public void setUp() throws Exception {
        productDao = new ProductDaoImpl();
        product = new Product(2, "Lenovo Yoga", 150);
    }

    @After
    public void tearDown() throws Exception {
        productDao = null;
        product = null;
    }

    @Test
    public void findPriceByCode() {
        double expected = 150;
        double actual = 0;
        try {
            actual = productDao.findPriceByCode(2);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);
    }

    @Test
    public void findProductByCode() {
        Product actual = null;
        Product expected = product;
        try {
            actual = productDao.findByCode(2);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);
    }

    @Test
    public void findAll() {
        int expectedSize = 16;
        List<Product> products = null;
        try {
            products = productDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        int actual = products.size();
        assertEquals(actual, expectedSize);
    }

}

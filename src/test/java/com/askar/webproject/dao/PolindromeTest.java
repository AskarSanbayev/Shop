package com.askar.webproject.dao;

import com.askar.webproject.Polyndrome;
import com.askar.webproject.dao.impl.AccountDaoImpl;
import com.askar.webproject.model.entity.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PolindromeTest {

    Polyndrome polyndrome;

    @Before
    public void setUp() throws Exception {
       polyndrome = new Polyndrome("asksa");
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void isPolyndromTest(){
        boolean expected = true;
        boolean actual = polyndrome.isPalinDrome();
        assertEquals(actual, expected);
    }

    @Test
    public void isAbcddcbaPolyndrom() {
        polyndrome = new Polyndrome("abcddcba");
        assertEquals(polyndrome.isPalinDrome(), true);
    }

    @Test
    public void isAbbaPolyndrom() {
        polyndrome = new Polyndrome("abdcba");
        assertEquals(polyndrome.isPalinDrome(), false);
    }

    @Test
    public void isAdbbaPolyndrom() {
        polyndrome = new Polyndrome("abdcba");
        assertEquals(polyndrome.isPalinDrome(), false);
        assertEquals(polyndrome.isPalinDrome(), false);
    }
}

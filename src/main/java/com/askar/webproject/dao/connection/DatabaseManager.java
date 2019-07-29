package com.askar.webproject.dao.connection;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DatabaseManager {

    static final String JDBC_MYSQL_DRIVER = "db.driver";
    static final String DATABASE_URL = "db.url";
    static final String DATABASE_USER = "db.user";
    static final String DATABASE_PASSWORD = "db.password";
    static final String CONNECTION_COUNT = "db.connectionCount";
    private static final String CONFIG_FILE_NAME = "db";

    private static ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE_NAME);

    private DatabaseManager() {

    }

    public static String getValue(String key) {
        String result = null;
        if (key != null) {
            try {
                result = bundle.getString(key);
            } catch (MissingResourceException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

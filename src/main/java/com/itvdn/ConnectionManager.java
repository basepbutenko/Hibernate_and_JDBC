package com.itvdn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";
    private static final String URL_KEY = "db.url";

    private ConnectionManager() {
    }

//    public static Connection open() {
//        try {
//
//            return DriverManager.getConnection(
//                    PropertiesUtil.get(URL_KEY),       // URL - первым
//                    PropertiesUtil.get(USERNAME_KEY), // Имя пользователя - вторым
//                    PropertiesUtil.get(PASSWORD_KEY)  // Пароль - третьим
//            );
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
public static Connection open() {
    try {
        Class.forName("org.postgresql.Driver"); // Регистрация драйвера
        return DriverManager.getConnection(
                PropertiesUtil.get("db.url"),
                PropertiesUtil.get("db.username"),
                PropertiesUtil.get("db.password")
        );
    } catch (ClassNotFoundException | SQLException e) {
        throw new RuntimeException(e);
    }
}
}

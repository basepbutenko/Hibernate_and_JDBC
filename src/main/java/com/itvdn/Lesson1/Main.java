package com.itvdn.Lesson1;

import com.itvdn.Lesson1.util.ConnectionManager;

import java.sql.DriverManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (var connection = ConnectionManager.open()) {
            System.out.println(connection.getCatalog());// returns our catalog postgres
            System.out.println(connection.getClientInfo());// can see JDBC driver
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
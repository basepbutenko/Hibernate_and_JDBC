package com.itvdn.Lesson1;

import com.itvdn.Lesson1.util.ConnectionManager;

import java.sql.DriverManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String createStudentTableSql = """
                CREATE TABLE IF NOT EXISTS students (
                id int PRIMARY KEY,
                FIRST_NAME varchar(255) NOT NULL,
                LAST_NAME varchar(255) NOT NULL,
                EMAIL varchar(255) NOT NULL
                 );

                """;
        String insertStudentsSql= """
                INSERT INTO students ( id, FIRST_NAME, LAST_NAME, EMAIL)
                VALUES
                ( 1, 'George', 'Smith', 'abcdef@gmail.com' ),
                (2,  'Nick', 'aa', 'aaaaaaa@gmail.com' ),
                ( 3, 'Filip', 'bb', 'bbbbbbb@gmail.com' ),
                (4,  'Stiven', 'ccc', 'cccccccc@gmail.com' ),
                (5, 'Martin', 'ddd ', 'dddddddddd@gmail.com' )
                """;
//        String createTeachersTableSql = """
//                CREATE TABLE IF NOT EXISTS teachers (
//                id int PRIMARY KEY,
//                FIRST_NAME varchar(255) NOT NULL,
//                LAST_NAME varchar(255) NOT NULL,
//                LESSON_NAME varchar(255) NOT NULL
//                 );
//                """;
        String dropTableTeachersSql= """
                DROP TABLE IF EXISTS teachers;
                """;
        String dropTableStudentsSql= """
                DROP TABLE IF EXISTS students;
                """;
        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
//            statement.execute(createStudentTableSql);
            statement.executeUpdate(insertStudentsSql);
//            statement.execute(createTeachersTableSql);
//            statement.execute(dropTableStudentsSql);
//            statement.execute(dropTableTeachersSql);
//            System.out.println(connection.getCatalog());// returns our catalog postgres
//            System.out.println(connection.getClientInfo());// can see JDBC driver
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
package com.itvdn.Lesson1;

import com.itvdn.Lesson1.util.ConnectionManager;

import java.sql.DriverManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String createCoursesTableSql = """
                CREATE TABLE IF NOT EXISTS courses (
                id INT PRIMARY KEY,
                course_name VARCHAR(255) NOT NULL,
                description VARCHAR(255) NOT NULL,
                duration INT
                 );

                """;
        String createEnrollmentTableSql = """
                CREATE TABLE IF NOT EXISTS enrollments (
                 id int PRIMARY KEY,
                student_id INT NOT NULL,
                course_id INT NOT NULL,
                FOREIGN KEY(student_id) REFERENCES students(id),
                FOREIGN KEY(course_id) REFERENCES courses(id)
                 );

                """;
//        String insertCoursesSql= """
//               INSERT INTO courses ( id, course_name, description, duration)
//                VALUES
//                ( 1, 'Introduction to Java', 'Basic Java Programming', 30 ),
//                (2,  'JDBC Basics', 'Introduction to JDBC', 25 ),
//                ( 3, 'Maven', 'Basics', 10 ),
//                (4,  'JUnit 4', 'Advanced', 15 )
//                """;
//        String insertEnrollmentSql= """
//               INSERT INTO enrollments ( id, student_id, course_id)
//                VALUES
//                ( 1, 1,1),
//                ( 2, 2,2),
//                ( 3, 3,3)
//                """;
//        String insertStudentsSql= """
//                INSERT INTO students ( id, FIRST_NAME, LAST_NAME, EMAIL)
//                VALUES
//                ( 1, 'George', 'Smith', 'abcdef@gmail.com' ),
//                (2,  'Nick', 'aa', 'aaaaaaa@gmail.com' ),
//                ( 3, 'Filip', 'bb', 'bbbbbbb@gmail.com' ),
//                (4,  'Stiven', 'ccc', 'cccccccc@gmail.com' ),
//                (5, 'Martin', 'ddd ', 'dddddddddd@gmail.com' )
//                """;
//        String createTeachersTableSql = """
//                CREATE TABLE IF NOT EXISTS teachers (
//                id int PRIMARY KEY,
//                FIRST_NAME varchar(255) NOT NULL,
//                LAST_NAME varchar(255) NOT NULL,
//                LESSON_NAME varchar(255) NOT NULL
//                 );
//                """;
//        String dropTableTeachersSql= """
//                DROP TABLE IF EXISTS teachers;
//                """;
//        String dropTableStudentsSql= """
//                DROP TABLE IF EXISTS students;
//                """;
        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
//            statement.execute(createCoursesTableSql);
//            statement.execute(createEnrollmentTableSql);
//            statement.execute(createStudentTableSql);
//            statement.executeUpdate(insertStudentsSql);
//            statement.executeUpdate(insertCoursesSql);
//            statement.executeUpdate(insertEnrollmentSql);
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
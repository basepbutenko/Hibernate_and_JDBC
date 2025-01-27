package Lesson2;

import com.itvdn.Lesson1.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransaction {
    public static void main(String[] args) throws SQLException {
        Integer courseId = 2;// we're going to delete this id
        String deleteEnrollment = """ 
                DELETE FROM enrollments WHERE course_id = ? ;
                """;
        String deleteCourses = """
                DELETE FROM courses WHERE id = ?; 
                """;
        Connection connection = null;
        PreparedStatement deleteEnrollmentStatement = null;
        PreparedStatement deleteCoursesStatement = null;

        try {
            connection = ConnectionManager.open();
            deleteEnrollmentStatement = connection.prepareStatement(deleteEnrollment);
            deleteCoursesStatement = connection.prepareStatement(deleteCourses);
            connection.setAutoCommit(false);

            deleteCoursesStatement.setInt(1, courseId);
            deleteEnrollmentStatement.setInt(1, courseId);
//            deleteCoursesStatement.executeUpdate();

            deleteEnrollmentStatement.executeUpdate();
            connection.commit();
            if (true) {
                throw new RuntimeException("Something went wrong");
            }
        } catch (
                 Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;

        }finally {
             if(connection != null){
                 connection.close();
             }
             if (deleteEnrollmentStatement != null) {
                 deleteEnrollmentStatement.close();
             }
             if (deleteCoursesStatement != null) {
                 deleteCoursesStatement.close();
             }
        }
    }
}

package Lesson2;

import Lesson2.dao.StudentDao;
import Lesson2.entity.Student;
import com.itvdn.Lesson1.util.ConnectionManager;

import java.sql.SQLException;

public class JdbcAdvanced {
    public static void main(String[] args) {
        StudentDao studentDao=StudentDao.getInstance();
//        Student student=new Student();
//        student.setFirstName("Test main");
//        student.setLastName("test main LM");
//        student.setEmail("test@test.com");
//    var studentFromDB=studentDao.save(student);
//        System.out.println(studentFromDB.toString());
    var studentById=studentDao.findById(5);
    System.out.println(studentById.toString());
    }
}







//        Integer studentsId=2;
//
//        String email="bbbbbbb@gmail.com OR TRUE" ; // String email="bbbbbbb@gmail.com" - different student if parameter's different
//        gerStudents(studentsId, email);

//        String studentsId="3 or 1=1 "; // or true
//        gerStudents(studentsId);
//        String studentsId="3; DROP TABLE test1 "; // or true
//        gerStudents(studentsId);

//    }
//
//    public static void gerStudents(Integer id,String email) {
//        String sql = """
//                select * from students WHERE id = ? OR email=?;
//                """;
//
//        try (var connection = ConnectionManager.open();
//             var prepareStatement = connection.prepareStatement(sql)) {
//            prepareStatement.setInt(1, id);// 1 because we have only one ?
//            prepareStatement.setString(2, email);
//            var resultSet = prepareStatement .executeQuery();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("first_name"));
//                System.out.println(resultSet.getString("last_name"));
//                System.out.println(resultSet.getString("email"));
//                System.out.println("------------------------NEXT STUDENT'S DATA-----------------");
//            }
//            System.out.println(resultSet);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

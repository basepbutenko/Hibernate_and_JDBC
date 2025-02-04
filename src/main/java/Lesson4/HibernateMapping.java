package Lesson4;

import Lesson4.Entity.Courses;
import Lesson4.Entity.Enrollment;
import Lesson4.Entity.Student;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class HibernateMapping  {
    public static void main(String[] args) {
         var configuration = new Configuration();
         configuration.configure();

         try (var sessionFactory = configuration.buildSessionFactory();
         var session = sessionFactory.openSession() ) {
             session.beginTransaction();

             Student student =  Student.builder()
                     .email("TestOfId@gmail.com")
                     .firstName("TestOfId")
                     .lastName("TestOfId")
                     .build();
             Courses courses= Courses.builder()
                     .description("Introduction to JDBC1")
                     .duration(40)
                     .name("JDBC Basis1")
                     .build();

             Enrollment enrollment = Enrollment.builder()
                     .student(student)
                     .course(courses)
                     .registrationDate (LocalDateTime.of(2025,5,30, 10, 8  ))
                     .build();
             session.persist(student);
             session.persist(courses);
             session.persist(enrollment);
//             var studentFromDb= session.find(Student.class, 3);
//             studentFromDb.getEnrollments().stream().map(e->e.getCourse() .getName()).forEach(e->System.out.println());

             session.getTransaction().commit();

         }

    }
}

package Lesson5;

import Lesson5.Entity.Student;
import org.hibernate.cfg.Configuration;

public class HibernateQueries {
    public static void main(String[] args) {
        var configuration = new Configuration();
        configuration.configure();

        String course="JDBC Basis1";
        String hql = "SELECT s FROM Enrollment e join  e.student s WHERE e.course.name= :courseName  ";

        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var result=session.createNamedQuery("StudentByCourse", Student.class).setParameter("courseName" , course). list();
            result.forEach(System.out::println);
            session.getTransaction().commit();


        }
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        System.out.println(student.getEnrollments().size());

    }
}

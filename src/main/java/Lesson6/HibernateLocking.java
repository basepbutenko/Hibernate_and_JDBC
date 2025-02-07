package Lesson6;

import Lesson6.Entity.Student;
import org.hibernate.LockMode;
import org.hibernate.cfg.Configuration;

public class HibernateLocking {
    public static void main(String[] args) {
        var configuration = new Configuration();
                configuration.configure();

        try (var sessionFactory = configuration.buildSessionFactory();
             var session1 = sessionFactory.openSession();
             var session = sessionFactory.openSession()){
            session.beginTransaction();
            session1.beginTransaction();
            var result=session.find(Student.class, 4, LockMode.PESSIMISTIC_READ );
            result.setFirstName("Test Pessimistic Read1     ");

            var theSameStudent  =session1.find(Student.class, 1, LockMode.PESSIMISTIC_READ  );
            theSameStudent.setFirstName("Test Pessimistic Read2");



//            var result = session.createQuery("select s  from Student s join fetch s.enrollments", Student.class ).list();
//            result.stream().map (Student::getEnrollments).forEach(System.out::println);

            session.getTransaction().commit();
            session1.getTransaction().commit();

        }
    }
}

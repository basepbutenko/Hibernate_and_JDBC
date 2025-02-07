package Lesson6;

import Lesson6.Entity.Student;
import org.hibernate.LockMode;
import org.hibernate.cfg.Configuration;

public class HibernateCaching {
    public static void main(String[] args) {
        var configuration = new Configuration();
        configuration.configure();

        try (var sessionFactory = configuration.buildSessionFactory();
             var session1 = sessionFactory.openSession();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session1.beginTransaction();

            session.find(Student.class, 1);
            session.find(Student.class, 1);

            session1.find(Student.class, 1 );
            session1.find(Student.class, 1 );


//            var result = session.createQuery("select s  from Student s join fetch s.enrollments", Student.class ).list();
//            result.stream().map (Student::getEnrollments).forEach(System.out::println);

            session.getTransaction().commit();
            session1.getTransaction().commit();

        }
    }
}

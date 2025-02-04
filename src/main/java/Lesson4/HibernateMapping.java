package Lesson4;

import Lesson4.Entity.Student;
import org.hibernate.cfg.Configuration;

public class HibernateMapping  {
    public static void main(String[] args) {
         var configuration = new Configuration();
         configuration.configure();

         try (var sessionFactory = configuration.buildSessionFactory();
         var session = sessionFactory.openSession() ) {
             session.beginTransaction();

             Student student =  Student.builder()
                     //.id(6)
                     .Email("samAltman@gmail.com")
                     .FirstName("SAM")
                     .LastName("ALTMAN")
                     .build();
             session.persist(student);
             session.getTransaction().commit();

         }

    }
}

package Lesson3;

import Lesson3.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateBasics {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = Student.builder()

                    .firstName("Aleks")
                    .lastName("Smith")
                    .email("AleksSmith@example.com")
                    .build();
            session.persist(student);



            System.out.println("Student saved successfully: " + student);

             session.getTransaction().commit();

        }


    }


}


package Lesson5;

import Lesson5.Entity.Student;
import org.hibernate.cfg.Configuration;

public class HibernateQueries {
    public static void main(String[] args) {
        var configuration = new Configuration();
        configuration.configure();
        int pageNumber = 1;
        int pageSize = 6;

//        String course="JDBC Basis1";
//        String hql = "SELECT s FROM Enrollment e join  e.student s WHERE e.course.name= :courseName  ";

        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var cb=session.getCriteriaBuilder();
            var criteria=cb.createQuery(Student.class);

//            var student=criteria.from(Student.class);
//            criteria.select(student).where(
//                    cb.equal(student.get("id"), 1 )// filters
//            );
            var student1=criteria.from(Student.class);
            criteria.select(student1).orderBy(cb.desc(student1 .get("id")));

            var result=session.createQuery(criteria)
                    .setFirstResult((pageNumber - 1) * pageSize)
                    .setMaxResults(pageSize)
                    .list();

     //       var result=session.createNamedQuery("StudentByCourse", Student.class).setParameter("courseName" , course). list();
            result.forEach(System.out::println);
            session.getTransaction().commit();


        }

    }
}

package Lesson6.Entity;

import Lesson5.Entity.Enrollment;
import jakarta.persistence.*;
import jakarta.persistence.NamedQuery;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import java.util.List;

@Entity
@NamedQuery(name="StudentByCourse",  query = "SELECT s FROM Enrollment e join  e.student s WHERE e.course.name= :courseName")
@Builder

@ToString
@AllArgsConstructor

@NoArgsConstructor

@Data
@Cache( usage = CacheConcurrencyStrategy.READ_WRITE)
//@OptimisticLocking(type = OptimisticLockType.DIRTY)
//@DynamicUpdate
@Table(name = "students", schema = "public")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "student", fetch=FetchType.LAZY)
    @ToString.Exclude
//    @BatchSize(size=3)
//    @Fetch(FetchMode.SUBSELECT)
    private List<Lesson6.Entity.Enrollment> enrollments;
}

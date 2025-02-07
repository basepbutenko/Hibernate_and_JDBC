package Lesson6.Entity;

import Lesson5.Entity.Enrollment;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NamedQuery(name="StudentByCourse",  query = "SELECT s FROM Enrollment e join  e.student s WHERE e.course.name= :courseName")
@Builder

@ToString
@AllArgsConstructor

@NoArgsConstructor

@Data
@Table(name = "students", schema = "public")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "student", fetch=FetchType.LAZY)
    @ToString.Exclude
    private List<Lesson6.Entity.Enrollment> enrollments;
}

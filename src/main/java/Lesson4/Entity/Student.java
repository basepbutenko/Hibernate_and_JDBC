package Lesson4.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity

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
    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
}

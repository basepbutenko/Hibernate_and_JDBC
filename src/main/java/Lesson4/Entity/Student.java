package Lesson4.Entity;

import jakarta.persistence.Id;
import lombok.*;

@Builder

@ToString
@AllArgsConstructor

@NoArgsConstructor

@Data
public class Student  {
 //  @Id
    private Integer id;
    private String FirstName;
    private String LastName;
    private String Email;
}

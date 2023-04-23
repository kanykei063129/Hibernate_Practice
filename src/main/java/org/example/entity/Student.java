package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Gender;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    @SequenceGenerator(sequenceName = "student_seq", name = "student_gen", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    private String lastName;
    private String email;
    private int age;
    private Gender gender;

    public Student(String firstName, String lastName, String email, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }
}


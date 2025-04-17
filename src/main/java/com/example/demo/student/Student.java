package com.example.demo.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Setter
@Entity
@Table // Creates table in database for this object.
class Student {
    @Id // Primary Key.
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    @Getter
    private String name;
    @Getter
    private String email;
    @Getter
    private LocalDate dateOfBirth;

    @Transient // Specifies that this doesn't need to be a column in our database.
    private Integer age;

    public Student() {
    }

    Student(Long id, String name, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    Student(String name, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears(); // Calculates age using dateOfBirth of student.
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id = " + id +
                ", Name = '" + name + '\'' +
                ", Email = '" + email + '\'' +
                ", Date of Birth = " + dateOfBirth +
                ", Age = " + age +
                '}';
    }
}

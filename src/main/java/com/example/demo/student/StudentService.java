package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
class StudentService { // Talks between the API and our database.

    private final StudentRepository studentRepository;

    @Autowired
    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    List<Student> getStudents() {
        return studentRepository.findAll();
    }

    void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email is taken.");
        }
        studentRepository.save(student);
    }

    void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist.");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentId + " does not exist."
                ));

        if (isNameValid(name, student)) {
            student.setName(name);
        }

        if (isEmailValid(email, student)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken.");
            }
            student.setEmail(email);
        }

    }

    private boolean isEmailValid(String email, Student student) {
        return email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email);
    }

    private boolean isNameValid(String name, Student student) {
        return name != null && !name.isEmpty() && !Objects.equals(student.getName(), name);
    }
}

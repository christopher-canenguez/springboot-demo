package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
class StudentController { // For our rest endpoints.

    private final StudentService studentService;

    @Autowired
    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}

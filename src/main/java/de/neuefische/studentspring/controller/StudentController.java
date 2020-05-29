package de.neuefische.studentspring.controller;

import de.neuefische.studentspring.Service.StudentService;
import de.neuefische.studentspring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService service;

    // Injektion --> setzt Abhängigkeit zur Serviceklasse
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getStudents();
    }


    // added Student mit Postman (Body eingeben)
    @PutMapping
    public Student addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return student;
    }

}

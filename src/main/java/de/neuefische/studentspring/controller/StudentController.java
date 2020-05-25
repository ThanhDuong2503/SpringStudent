package de.neuefische.studentspring.controller;

import de.neuefische.studentspring.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("student")
public class StudentController {

    ArrayList<Student> studendlist = new ArrayList<>();

    public StudentController() {
        studendlist.add(new Student("Student 1", "1"));
        studendlist.add(new Student("Student 2", "2"));
        studendlist.add(new Student("Student 3", "3"));
    }
    @GetMapping
    public ArrayList<Student> getStudents() {

        return studendlist;
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable String id) {
        for (Student student : studendlist) {
            if(student.getId().equals(id)){
                return student;
            }

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student does not exist");
    }

    @PutMapping
    public Student addStudent(@RequestBody Student student){
        studendlist.add(student);
        return student;
    }



}

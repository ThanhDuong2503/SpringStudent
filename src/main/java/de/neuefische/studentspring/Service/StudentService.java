package de.neuefische.studentspring.Service;

import de.neuefische.studentspring.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

//definiert Serviceklasse
@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>(List.of(
            new Student("Bruce", "1", 20),
            new Student("Bruno", "2", 30),
            new Student("Steve", "3", 40),
            new Student("Lilly", "3", 25),
            new Student("Lessi", "3", 18)
    ));

    public StudentService() {
    }


    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;


    }
}

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
        studendlist.add(new Student("Bruce", "1", 20));
        studendlist.add(new Student("Bruno", "2", 30));
        studendlist.add(new Student("Steve", "3", 40));
        studendlist.add(new Student("Lilly", "3", 15));
        studendlist.add(new Student("Lessi", "3", 18));
    }

    //im browser: http://localhost:8080/student?q=L eingeben, um alle Studenten zu listen, die mit "L" anfangen
    //wenn kein "L" --> komplette studenlist gelistet

    @GetMapping
    public ArrayList<Student> getStudents(@RequestParam(name = "q", required=false) String query) {
        if (query == null) {
            return studendlist;
        }

    //erstellt Liste von gefundenen Studenten, die mit "L" anfangen
        // else if: suche nach id

        ArrayList<Student> matchingStudents = new ArrayList<>();
        for (Student student : studendlist) {
            if (student.getName().startsWith(query)) {
                matchingStudents.add(student);
            } else if (student.getId().startsWith(query)) {
                matchingStudents.add(student);
            }
        }
        return matchingStudents;
    }

    // im brwoser: http://localhost:8080/student/1 eingeben --> listet Studen mit id 1
    // wenn id nicht vorhanden --> Exception

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable String id) {
        for (Student student : studendlist) {
            if (student.getId().equals(id)) {
                return student;
            }

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student does not exist");
    }

    // added Student mit Postman (Body eingeben)

    @PutMapping
    public Student addStudent(@RequestBody Student student) {
        studendlist.add(student);
        return student;
    }


}

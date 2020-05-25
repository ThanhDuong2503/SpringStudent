package de.neuefische.studentspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping
    public ArrayList<Student> getStudents() {
        ArrayList<Student> studendlist = new ArrayList<>();
        studendlist.add(new Student("Student 1"));
        studendlist.add(new Student("Student 2"));
        studendlist.add(new Student("Student 3"));
        return studendlist;
    }
}

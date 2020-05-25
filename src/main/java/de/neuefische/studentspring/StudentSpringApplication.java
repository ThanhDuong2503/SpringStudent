package de.neuefische.studentspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class StudentSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSpringApplication.class, args);
    }


}

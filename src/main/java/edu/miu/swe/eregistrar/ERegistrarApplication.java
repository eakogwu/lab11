package edu.miu.swe.eregistrar;

import edu.miu.swe.eregistrar.model.Student;
import edu.miu.swe.eregistrar.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ERegistrarApplication implements CommandLineRunner {
    private final StudentService studentService;

    public ERegistrarApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var student  = new Student("514715","Winnie","","Muthike",  4.6f, LocalDate.of(2021, 5,24));
        var student1  = new Student("614715","Anna","","Smith",  4.0f, LocalDate.of(2021, 5,24));
        studentService.addNewStudent(student);
        studentService.addNewStudent(student1);
    }
}

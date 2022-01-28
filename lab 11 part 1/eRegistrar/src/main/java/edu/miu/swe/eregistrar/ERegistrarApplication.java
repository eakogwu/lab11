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
        var emmanuel  = new Student("612715","Emmanuel","","Akogwu",  4.3f, LocalDate.of(2021, 5,24));
        studentService.addNewStudent(emmanuel);
    }
}

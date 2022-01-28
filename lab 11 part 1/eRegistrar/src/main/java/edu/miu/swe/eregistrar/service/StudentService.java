package edu.miu.swe.eregistrar.service;

import edu.miu.swe.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    Student addNewStudent(Student student);
    void deleteStudent(Student student);
    Student updateStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
}

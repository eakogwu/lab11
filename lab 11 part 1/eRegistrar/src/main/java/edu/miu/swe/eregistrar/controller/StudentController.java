package edu.miu.swe.eregistrar.controller;

import edu.miu.swe.eregistrar.model.Student;
import edu.miu.swe.eregistrar.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ModelAndView getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students",students);
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @GetMapping("/new")
    public String addNewStudent(Model model){
        model.addAttribute("student",new Student() );
        return "addStudent";
    }

    @PostMapping
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
        }
        return "redirect:addStudent";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id, Model model){
        studentService.deleteStudent(studentService.getStudentById(id));
        return "redirect:/students";
    }

}

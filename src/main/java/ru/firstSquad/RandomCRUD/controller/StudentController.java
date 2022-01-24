package ru.firstSquad.RandomCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.firstSquad.RandomCRUD.model.Student;
import ru.firstSquad.RandomCRUD.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/student-create")
    public String createStudentForm(Student student) {
        return "student-create";
    }

    @PostMapping("/student-create")
    public String createStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("student-delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("student-update/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "/student-update";
    }

    @PostMapping("/student-update")
    public String updateStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }
}

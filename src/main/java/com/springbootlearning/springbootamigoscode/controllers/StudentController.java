package com.springbootlearning.springbootamigoscode.controllers;
import com.springbootlearning.springbootamigoscode.entities.Student;
import com.springbootlearning.springbootamigoscode.entities.StudentUpdateDTO;
import com.springbootlearning.springbootamigoscode.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public String registerNewStudent(@RequestBody Student student) {
        return studentService.registerNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        return studentService.deleteStudent(studentId);
    }

    //https://stackoverflow.com/questions/40902280/what-is-the-recommended-project-structure-for-spring-boot-rest-projects
    @PutMapping(path = "{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId, @RequestBody StudentUpdateDTO json){
        String name = json.getName();
        String email = json.getEmail();
        System.out.println("@@@@@@@@@@@@@@@@@@@@" + name + "@@@@@@@@@@@@@@@@" + email);
        return studentService.updatedStudent(studentId, name, email);
    }
}

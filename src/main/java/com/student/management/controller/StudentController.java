package com.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.management.entity.Student;
import com.student.management.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Add Student")
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @Operation(summary = "Get All Students")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Get Student By ID")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @Operation(summary = "Update Student")
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @Valid @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

    @Operation(summary = "Delete Student")
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }

    @Operation(summary = "Search Student By Name")
    @GetMapping("/search/{name}")
    public List<Student> searchStudent(@PathVariable String name) {
        return studentService.searchStudentByName(name);
    }

}
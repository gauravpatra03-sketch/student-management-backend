package com.student.management.service;

import java.util.List;

import com.student.management.entity.Student;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Integer id);

    Student updateStudent(Integer id, Student student);

    String deleteStudent(Integer id);

    List<Student> searchStudentByName(String name);

}
package com.student.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.entity.Student;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {

            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setMobile(student.getMobile());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setGender(student.getGender());
            existingStudent.setDob(student.getDob());

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    @Override
    public String deleteStudent(Integer id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            studentRepository.delete(student);
            return "Student deleted successfully";
        }

        return "Student not found";
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

}
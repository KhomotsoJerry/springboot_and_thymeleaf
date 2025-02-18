package com.khomotso.springboot_thymeleaf_crud_web_app.service;

import com.khomotso.springboot_thymeleaf_crud_web_app.model.Student;
import com.khomotso.springboot_thymeleaf_crud_web_app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()){
            student = optional.get();
        }else{
            throw new RuntimeException("student of id ::"+id +" not found");
        }
        return student;
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}

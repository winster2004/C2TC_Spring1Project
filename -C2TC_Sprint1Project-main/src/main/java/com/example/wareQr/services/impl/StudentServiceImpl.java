package com.example.wareQr.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wareQr.model.Student;
import com.example.wareQr.repository.StudentRepository;
import com.example.wareQr.serviceee.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

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
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existing = studentRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setQualification(student.getQualification());
            existing.setYearOfPassout(student.getYearOfPassout());
            return studentRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

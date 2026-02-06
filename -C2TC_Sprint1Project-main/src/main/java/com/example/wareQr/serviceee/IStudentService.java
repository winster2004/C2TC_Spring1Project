package com.example.wareQr.serviceee;


import java.util.List;

import com.example.wareQr.model.Student;

public interface IStudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}


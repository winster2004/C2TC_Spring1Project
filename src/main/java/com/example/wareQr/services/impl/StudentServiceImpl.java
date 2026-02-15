package com.example.wareQr.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wareQr.model.College;
import com.example.wareQr.model.Student;
import com.example.wareQr.repository.CollegeRepository;
import com.example.wareQr.repository.StudentRepository;
import com.example.wareQr.serviceee.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CollegeRepository collegeRepository;

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
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {

        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existing.setName(studentDetails.getName());
        existing.setEmail(studentDetails.getEmail());
        existing.setQualification(studentDetails.getQualification());
        existing.setYearOfPassout(studentDetails.getYearOfPassout());

        // 🔥 IMPORTANT PART — UPDATE COLLEGE
        if (studentDetails.getCollege() != null &&
            studentDetails.getCollege().getCollegeId() != null) {

            College college = collegeRepository
                    .findById(studentDetails.getCollege().getCollegeId())
                    .orElseThrow(() -> new RuntimeException("College not found"));

            existing.setCollege(college);
        } else {
            existing.setCollege(null);
        }

        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}

package com.example.wareQr.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wareQr.model.College;
import com.example.wareQr.repository.CollegeRepository;
import com.example.wareQr.serviceee.ICollegeService;

@Service
public class CollegeServiceImpl implements ICollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public College addCollege(College college) {
        return collegeRepository.save(college);
    }

    @Override
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    @Override
    public College getCollegeById(Long id) {
        return collegeRepository.findById(id).orElse(null);
    }

    @Override
    public College updateCollege(Long id, College college) {
        College existing = collegeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCollegeName(college.getCollegeName());
            existing.setLocation(college.getLocation());
            return collegeRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }
}
package com.example.wareQr.serviceee;

import java.util.List;

import com.example.wareQr.model.College;

public interface ICollegeService {

    College addCollege(College college);

    List<College> getAllColleges();

    College getCollegeById(Long id);

    College updateCollege(Long id, College college);

    void deleteCollege(Long id);
}
package com.example.wareQr.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wareQr.model.College;
import com.example.wareQr.serviceee.ICollegeService;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private ICollegeService collegeService;

    @PostMapping
    public College addCollege(@RequestBody College college) {
        return collegeService.addCollege(college);
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id);
    }

    @PutMapping("/{id}")
    public College updateCollege(@PathVariable Long id, @RequestBody College college) {
        return collegeService.updateCollege(id, college);
    }

    @DeleteMapping("/{id}")
    public void deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
    }
}
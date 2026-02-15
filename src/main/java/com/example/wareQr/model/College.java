package com.example.wareQr.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collegeId;

    private String collegeName;
    private String location;

    // One College -> Many Students
    @OneToMany(mappedBy = "college")
    @JsonIgnore
    @JsonIgnoreProperties("college")
    private List<Student> students;


    // One College -> Many Placements
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Placement> placements;

    // Getters and Setters
    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getLocation() {
        return location;
    }
 
    public void setLocation(String location) {
        this.location = location;
    }

    public List<Student> getStudents() {
        return students;
    }
 
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Placement> getPlacements() {
        return placements;
    }
 
    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }
}

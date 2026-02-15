package com.example.wareQr.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placementId;

    private String companyName;
    private String jobRole;
    private Double salary;
    private LocalDate placementDate;

    // Many Placements -> One Student
    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties({"certificates", "placements"})
    private Student student;

    // Many Placements -> One College
    @ManyToOne
    @JoinColumn(name = "college_id")
    @JsonIgnoreProperties({"students", "placements"})
    private College college;

    // Getters and Setters
    public Long getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Long placementId) {
        this.placementId = placementId;
    }

    public String getCompanyName() {
        return companyName;
    }
 
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobRole() {
        return jobRole;
    }
 
    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public Double getSalary() {
        return salary;
    }
 
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getPlacementDate() {
        return placementDate;
    }
 
    public void setPlacementDate(LocalDate placementDate) {
        this.placementDate = placementDate;
    }

    public Student getStudent() {
        return student;
    }
 
    public void setStudent(Student student) {
        this.student = student;
    }

    public College getCollege() {
        return college;
    }
 
    public void setCollege(College college) {
        this.college = college;
    }
}

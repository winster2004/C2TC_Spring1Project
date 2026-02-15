package com.example.wareQr.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String name;
    private String email;
    private String qualification;
    private int yearOfPassout;

    // Many Students -> One College
    @ManyToOne
    @JoinColumn(name = "college_id")
    @JsonIgnoreProperties({"students", "placements"})
    private College college;

    // One Student -> Many Certificates
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Certificate> certificates;

    // One Student -> Many Placements
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Placement> placements;

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualification() {
        return qualification;
    }
 
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getYearOfPassout() {
        return yearOfPassout;
    }
 
    public void setYearOfPassout(int yearOfPassout) {
        this.yearOfPassout = yearOfPassout;
    }

    public College getCollege() {
        return college;
    }
 
    public void setCollege(College college) {
        this.college = college;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }
 
    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public List<Placement> getPlacements() {
        return placements;
    }
 
    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }
}

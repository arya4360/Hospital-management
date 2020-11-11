package com.example.demo.modal;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String firstname;
    private String lastname ;
    private String contactnumber ;
    private String password ;
    private String qualifications ;
    private String specialization ;
    private String email ;
    private String role = "DOCTOR" ;



    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

package com.example.demo.modal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String description ;
    private String prescription ;
    private String complaint ;
    @Temporal(TemporalType.DATE)
    private Date date ;
    private boolean complaintForward = false ;

    @ManyToOne
    private patient patient;

    @ManyToOne
    private doctor doctor ;

    public boolean isComplaintForward() {
        return complaintForward;
    }

    public void setComplaintForward(boolean complaintForward) {
        this.complaintForward = complaintForward;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public int getId() {
        return id;
    }

    public patient getPatient() {
        return patient;
    }

    public void setPatient(patient patient) {
        this.patient = patient;
    }

    public doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(doctor doctor) {
        this.doctor = doctor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

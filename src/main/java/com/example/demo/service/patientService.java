package com.example.demo.service;

import com.example.demo.Repository.patientRepository;
import com.example.demo.modal.patient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patientService")
public class patientService {

    private patientRepository patientRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public patientService(patientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public void savePatient(patient patient){
        String pwd = patient.getPassword();
        String encodedPwd = passwordEncoder.encode(pwd);
        patient.setPassword(encodedPwd);
        patientRepository.save(patient);
    }


    public List<patient> getAllPatient(){
        return patientRepository.findAll();
    }

    public List<patient> deletePatient(int id){
        patientRepository.deleteById(id);
        return patientRepository.findAll();
    }
    public patient fetchPatientByUsernameAndPassword(String username, String password){
        System.out.println("patient found with these credentials");
        return patientRepository.findByUsernameAndPassword(username,password);
    }
//    public patient findByConfirmationToken(String confirmationToken){
//        return patientRepository.findByConfirmationToken(confirmationToken);
//    }


}

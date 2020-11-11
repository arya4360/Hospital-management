package com.example.demo.controller;

import com.example.demo.modal.patient;
import com.example.demo.service.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
public class mainController {


//    @Autowired
//    private patientRepository patientRepository;
    @Autowired
    private patientService patientService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @CrossOrigin("*")
    @PostMapping("/patient/addPatient")
    public String addPatient(@RequestBody patient patient){
        this.patientService.savePatient(patient);
        return " patient Registered sucessfully: " + patient.getUsername() ;
    }
    @CrossOrigin("*")
    @GetMapping("/getAllPatients")
    public List<patient> getAllPatients(){
        return patientService.getAllPatient();
    }

    @GetMapping("/remove/{id}")
    @CrossOrigin("*")
    public List<patient> removePatient(@PathVariable int id){
        return patientService.deletePatient(id);

    }
    @PostMapping("/loginPatient")
    @CrossOrigin("*")
    public String loginPatient(@RequestBody patient patient) throws Exception{
        String tempUsername = patient.getUsername();
        String tempPassword = patient.getPassword();
        String encodedPwd = passwordEncoder.encode(tempPassword);
        patient.setPassword(encodedPwd);
        patient patientObj = null;
        if (tempUsername != null && tempPassword != null){
            patientObj = patientService.fetchPatientByUsernameAndPassword(tempUsername, tempPassword);
        }
        if (patientObj ==null)
            throw new Exception("user does not exist");

        return "Logged in Sucessfully as :" + patientObj.getUsername();
    }


//    @GetMapping("/sign-up")
//    String signUp() {
//
//        return "sign-up";
//    }
//
//    @PostMapping("/sign-up")
//    String signUp(patient patient) {
//
//        patientService.savePatient(patient);
//
//        return "redirect:/sign-in";
//    }

}

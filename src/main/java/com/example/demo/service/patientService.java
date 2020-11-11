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

    public String savePatient(patient patientNew) {
        patient existPatientUsername = patientRepository.findByusername(patientNew.getUsername());
        patient existPatientEmail = patientRepository.findByemail(patientNew.getEmail());
        if (existPatientUsername == null && existPatientEmail == null) {
//        String pwd = patientNew.getPassword();                         //  if you want to encrypt password then uncomment these lines
//        String encodedPwd = passwordEncoder.encode(pwd);
//        patientNew.setPassword(encodedPwd);
            patientRepository.save(patientNew);
            return patientNew.getUsername() + ", your registration request has been forwarded to the receptionist" ;
        }else
        return "patient with this username or email already exist." ;
    }

    public String updatePatientDetail(int id, patient patient){
        patient patientFromDb = patientRepository.findById(id).get();
        patientFromDb.setFirstName(patient.getFirstName());
        patientFromDb.setLastName(patient.getLastName());
        patientFromDb.setPassword(patient.getPassword());
        patientFromDb.setContactNumber(patient.getContactNumber());
        patientRepository.saveAndFlush(patientFromDb);
        return "Record updated of username: " + patientFromDb.getUsername() ;
    }

    public List<patient> getAllPatient(){
        return patientRepository.findAll();
    }
    public patient getPatient(int id){return patientRepository.findById(id).get() ;}

    public List<patient> deletePatient(int id){
        patientRepository.deleteById(id);
        return patientRepository.findAll();
    }
    public List<patient> getBooleanService(boolean verify){
        return patientRepository.findAllByVerify(verify);
    }
    public patient fetchPatientByUsernameAndPassword(String username, String password, boolean verify){
        System.out.println("patient found with these credentials");
        return patientRepository.findByUsernameAndPasswordAndVerify(username,password , verify);
    }
    public List<patient> verifyPatient(int id){
        patient tempPatient = patientRepository.findById(id).get();
        tempPatient.setVerify(true);
        patientRepository.saveAndFlush(tempPatient);
        return patientRepository.findAllByVerify(false);
//        return patientRepository.findById(id).get().getUsername() +" has been verified" ;
    }

}

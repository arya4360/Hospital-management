package com.example.demo.service;

import com.example.demo.Repository.doctorRepository;
import com.example.demo.modal.doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("doctorService")
public class doctorService {

    @Autowired
    doctorRepository doctorRepository ;

    public void saveDoctor(doctor doctor){
//        String pwd = patient.getPassword();
//        String encodedPwd = passwordEncoder.encode(pwd);
//        patient.setPassword(encodedPwd);
        doctorRepository.save(doctor);
    }
    public List<doctor> getDoctors(){
        return doctorRepository.findAll() ;
    }
    public doctor getDoctorById(int id){
        return doctorRepository.findById(id).get() ;
    }
    public List<doctor> deleteDoctor(int id){
        doctorRepository.deleteById(id);
        return doctorRepository.findAll();
    }
    public String updateDetails(int id , doctor doctor){
        doctor doctorFromDb = doctorRepository.findById(id).get();
        doctorFromDb.setContactnumber(doctor.getContactnumber());
        doctorFromDb.setEmail(doctor.getEmail());
        doctorFromDb.setFirstname(doctor.getFirstname());
        doctorFromDb.setLastname(doctor.getLastname());
        doctorFromDb.setQualifications(doctor.getQualifications());
        doctorFromDb.setSpecialization(doctor.getSpecialization());
        doctorRepository.saveAndFlush(doctorFromDb);
        return doctorFromDb.getFirstname() + doctorFromDb.getLastname() + " details has been updated sucessfully.";
    }
    public doctor fetchDoctorByusernameAndpassword(String username , String password){
        return doctorRepository.findByUsernameAndPassword(username , password);
    }
}

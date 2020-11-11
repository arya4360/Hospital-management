package com.example.demo.service;

import com.example.demo.Repository.appointmentRepository;
import com.example.demo.modal.appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appointmentService")
public class appointmentService {

    @Autowired
    private appointmentRepository appointmentRepository ;

    public List<appointment> getByPatientIdService(int id){
           return this.appointmentRepository.findAllByPatient_id(id);
    }
    public List<appointment> getByDoctorIdService(int id){
        return this.appointmentRepository.findAllBydoctor_id(id) ;
    }
    public List<appointment> getAllAppointments(){
        return this.appointmentRepository.findAllByOrderByIdDesc() ;
    }
    public String saveAppointmentService(appointment appointment){
        this.appointmentRepository.save(appointment);
        return "appointment saved" ;
    }
    public String prescriptionService(int id, appointment appointment ){
        appointment appointmentFromDb = this.appointmentRepository.findById(id).get();
        appointmentFromDb.setPrescription(appointment.getPrescription());
        appointmentRepository.saveAndFlush(appointmentFromDb);
        return "prescription given" ;
    }
    public String complaintService(int id , appointment appointment){
        appointment tempAppointment = this.appointmentRepository.findById(id).get();
        tempAppointment.setComplaint(appointment.getComplaint());
        appointmentRepository.saveAndFlush(tempAppointment);
        return "complaint successfully registered" ;
    }
    public appointment getAppointmentSevice(int id){
        return this.appointmentRepository.findById(id).get() ;
    }
    public List<appointment> deleteAppointmentService(int id){
        this.appointmentRepository.deleteById(id);
        return appointmentRepository.findAllByOrderByIdDesc();
    }
    public List<appointment> getPrescriptionNullService(){
        return this.appointmentRepository.findAllByPrescription(null) ;
    }
    public List<appointment> forwardComplaintService(int id){
        appointment tempAppointment = this.appointmentRepository.findById(id).get() ;
        tempAppointment.setComplaintForward(true);
        appointmentRepository.saveAndFlush(tempAppointment);
        return appointmentRepository.findAllByOrderByIdDesc() ;
    }
}

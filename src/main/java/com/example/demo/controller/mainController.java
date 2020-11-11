package com.example.demo.controller;

import com.example.demo.modal.appointment;
import com.example.demo.modal.doctor;
import com.example.demo.modal.patient;
import com.example.demo.service.appointmentService;
import com.example.demo.service.doctorService;
import com.example.demo.service.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@CrossOrigin("*")
public class mainController {


//    @Autowired
//    private patientRepository patientRepository;
    @Autowired
    private patientService patientService;
    @Autowired
    private doctorService doctorService ;
    @Autowired
    private appointmentService appointmentService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/patient/addPatient")
    public String addPatient(@RequestBody patient patient){
        return this.patientService.savePatient(patient);
    }
    @PutMapping("/patient/updateDetails/{id}")
    public String update(@PathVariable int id,  @RequestBody patient patient){
        return patientService.updatePatientDetail(id, patient);
    }
    @GetMapping("/getAllPatients")
    public List<patient> getAllPatients(){
        return patientService.getAllPatient();
    }

    @GetMapping("/getPatient/{id}")
    public patient getPatientById(@PathVariable int id){return patientService.getPatient(id);}

    @GetMapping("/remove/{id}")
    public List<patient> removePatient(@PathVariable int id){
        return patientService.deletePatient(id);
    }
    @PostMapping("/loginPatient")
    public int loginPatient(@RequestBody patient patient) throws Exception{
        String tempUsername = patient.getUsername();
        String tempPassword = patient.getPassword();
        String encodedPwd = passwordEncoder.encode(tempPassword);
        patient.setPassword(encodedPwd);
        boolean tempVerify = true;
        patient patientObj = null;
        if (tempUsername != null && tempPassword != null){
            patientObj = patientService.fetchPatientByUsernameAndPassword(tempUsername, tempPassword, tempVerify);
        }
        if (patientObj ==null) {
            System.out.println("user not exists or verified with for this user");
            throw new Exception("user does not exist");
        }
        return patientObj.getId() ;
    }
    @GetMapping("/patient/verify/{id}")
    public List<patient> patientVerification(@PathVariable int id){
        return this.patientService.verifyPatient(id) ;
    }
    @GetMapping("/getAllNotVerifiedPatients")
    public List<patient> getAllNotVerified(){
        return this.patientService.getBooleanService(false);
    }

    @GetMapping("/getAllVerifiedPatients")
    public List<patient> getAllVerified(){
        return this.patientService.getBooleanService(true);
    }

//    ------------------------------------Doctor controllers-----------------------------------
    @PostMapping("/doctor/addDoctor")
    public String addDoctor(@RequestBody doctor doctor){
        this.doctorService.saveDoctor(doctor);
        return doctor.getUsername() + " has been registered sucessfully" ;
    }
    @GetMapping("/doctor/getAllDoctors")
    public List<doctor> getAllDoctors(){
        return this.doctorService.getDoctors();
    }
    @GetMapping("/doctor/{id}")
    public doctor getDoctorById(@PathVariable int id){
        return this.doctorService.getDoctorById(id);
    }
    @GetMapping("/doctor/removeDoctor/{id}")
    public List<doctor> deleteDoctor(@PathVariable int id){
        return this.doctorService.deleteDoctor(id);
    }
    @PutMapping("/doctor/updateDetails/{id}")
    public String updateDoctorDetails( @PathVariable int id ,@RequestBody doctor doctor){
        return this.doctorService.updateDetails(id ,doctor);
    }
    @PostMapping("/doctor/loginDoctor")
    public int loginDoctor(@RequestBody doctor doctor) throws Exception{
        String username = doctor.getUsername();
        String password = doctor.getPassword();
        doctor tempDoctor = null ;
        if (username != null && password != null){
            tempDoctor = this.doctorService.fetchDoctorByusernameAndpassword(username ,password);
        }else {
            throw new Exception("Doctor with these credentials not found");
        }
        return tempDoctor.getId();
    }
//-------------------------------------------Appointment Controller-----------------------------------------

    @GetMapping("/appointment/patient/{id}")
    public List<appointment> getByPatientId(@PathVariable int id){
        return this.appointmentService.getByPatientIdService(id);
    }
    @GetMapping("/appointment/doctor/{id}")
    public List<appointment> getByDoctorId(@PathVariable int id){
        return this.appointmentService.getByDoctorIdService(id);
    }
    @PostMapping("/appointment/newAppointment")
    public String saveAppointment(@RequestBody appointment appointment){
        return this.appointmentService.saveAppointmentService(appointment);
    }
    @PutMapping("/appointment/prescription/{id}")
    public String prescription(@PathVariable int id , @RequestBody appointment appointment){
        return this.appointmentService.prescriptionService(id, appointment);
    }
    @GetMapping("/appointment/{id}")
    public appointment getAppointment(@PathVariable int id){
        return this.appointmentService.getAppointmentSevice(id) ;
    }
    @GetMapping("/appointment/delete/{id}")
    public List<appointment> deleteAppointment(@PathVariable int id){
        return  this.appointmentService.deleteAppointmentService(id);
    }
    @GetMapping("/appointment/allAppointments")
    public List<appointment> allAppointments(){
        return this.appointmentService.getAllAppointments() ;
    }
    @PutMapping("/appointment/complaint/{id}")
    public String complaint(@PathVariable int id , @RequestBody appointment appointment){
        return this.appointmentService.complaintService(id, appointment) ;
    }
    @GetMapping("/appointment/pending")
    public List<appointment> getAllNullPrescription(){
        return this.appointmentService.getPrescriptionNullService() ;
    }

    @GetMapping("/appointment/complaint/forward/{id}")
    public List<appointment> complaintForward(@PathVariable int id){
        return this.appointmentService.forwardComplaintService(id);
    }

}

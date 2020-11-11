package com.example.demo.Repository;

import com.example.demo.modal.appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface appointmentRepository extends JpaRepository<appointment , Integer> {

 List<appointment> findAllByPatient_id(int id);
 List<appointment> findAllBydoctor_id(int id);
 List<appointment> findAllByOrderByIdDesc();
 List<appointment> findAllByPrescription(String string) ;
}

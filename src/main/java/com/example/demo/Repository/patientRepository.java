package com.example.demo.Repository;

import com.example.demo.modal.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<patient, Integer> {

    patient findByusername(String username);

    patient findByUsernameAndPassword(String username, String password);

    //patient findByUserName(String username);
//    patient findByConfirmationToken(String confirmationToken);
}

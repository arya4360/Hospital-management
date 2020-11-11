package com.example.demo.Repository;

import com.example.demo.modal.patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface patientRepository extends JpaRepository<patient, Integer> {

    patient findByusername(String username);

    patient findByUsernameAndPasswordAndVerify(String username, String password, boolean verify);
    List<patient> findAllByVerify(boolean verify);

    patient findByemail(String email);

    //patient findByUserName(String username);
//    patient findByConfirmationToken(String confirmationToken);
}

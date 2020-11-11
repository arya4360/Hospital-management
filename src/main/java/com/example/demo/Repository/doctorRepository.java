package com.example.demo.Repository;

import com.example.demo.modal.doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRepository extends JpaRepository<doctor, Integer> {
    doctor findByusername(String username);

    doctor findByUsernameAndPassword(String username, String password);
}

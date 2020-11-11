package com.example.demo.service;

import com.example.demo.Repository.patientRepository;
import com.example.demo.modal.patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class userDetailService implements UserDetailsService {

    @Autowired
    private patientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        patient patient= patientRepository.findByusername(username);
        if (patient == null){
            throw new UsernameNotFoundException("patient not found exception");
        }
            return new customDetails(patient);
    }
}

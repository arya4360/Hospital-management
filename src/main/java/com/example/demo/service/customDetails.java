package com.example.demo.service;

import com.example.demo.modal.patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
public class customDetails implements UserDetails {

    private patient patient;

    public customDetails(patient patient){
        super();
        this.patient = patient;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("patient"));
    }

    @Override
    public String getPassword() {
        return patient.getPassword();
    }


    @Override
    public String getUsername() {
        return patient.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.example.demo.modal;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.text.DateFormat;

@Entity
@Table
@NoArgsConstructor
public class patient {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id ;

    @Column
    @NotNull
    private String username ;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String password;

    @Column
    @NonNull
    private String firstName;
    @Column
    @NotNull
    private String LastName;
    @Column
    private String city;
    @Column
    @NotNull
    private String state;
    @Column
    @NotNull
    private String country;
    @Column
    @NotNull
    private String contactNumber;
    @Column
    @NotNull
    private String dob;

    private String role = "patient";

    public String getRole() {
        return role;
    }

    //    @Column
//    private boolean enabled;

//    @Column
//    private String confirmationToken;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public String getState() {
        return state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return Id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.example.demo.controller;

import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/rest/secure")
public class testController {

    @CrossOrigin("*")
    @RequestMapping("/getMsg")
    public String getMsg(){
        return "logged in sucessfully happy now" ;
    }
}

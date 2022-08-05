package com.example.week7camperlab.controller;

import com.example.week7camperlab.model.Signup;
import com.example.week7camperlab.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camp")
public class SignupController {
    @Autowired
    SignupService signupService;

    @PostMapping("/signups")
    public ResponseEntity<Signup> createSignup(@RequestBody Signup signup) {
        Signup newSignup = signupService.createSignup(signup);
        return ResponseEntity.ok(newSignup);
    }

}

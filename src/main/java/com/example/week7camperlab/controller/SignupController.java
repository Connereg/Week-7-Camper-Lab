package com.example.week7camperlab.controller;

import com.example.week7camperlab.dto.CreateSignupDTO;
import com.example.week7camperlab.dto.GetActivitiesDTO;
import com.example.week7camperlab.model.Signup;
import com.example.week7camperlab.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/camp")
public class SignupController {
    @Autowired
    SignupService signupService;

    @PostMapping("/signups")
    public ResponseEntity<GetActivitiesDTO> createSignup(@Valid @RequestBody CreateSignupDTO createSignupDTO) {
        GetActivitiesDTO activityDTO = signupService.createSignup(createSignupDTO);
        return ResponseEntity.ok(activityDTO);
    }

}

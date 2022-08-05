package com.example.week7camperlab.service;

import com.example.week7camperlab.model.Signup;
import com.example.week7camperlab.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    SignupRepository signupRepository;

    public Signup createSignup(Signup signup) {
        return signupRepository.save(signup);
    }

}

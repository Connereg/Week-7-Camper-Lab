package com.example.week7camperlab.service;

import com.example.week7camperlab.dto.CreateSignupDTO;
import com.example.week7camperlab.dto.GetActivitiesDTO;
import com.example.week7camperlab.model.Activity;
import com.example.week7camperlab.model.Camper;
import com.example.week7camperlab.model.Signup;
import com.example.week7camperlab.repository.ActivityRepository;
import com.example.week7camperlab.repository.CamperRepository;
import com.example.week7camperlab.repository.SignupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

import java.util.List;

@Service
public class SignupService {
    @Autowired
    SignupRepository signupRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private CamperRepository camperRepository;

    @Autowired
    private ModelMapper mapper;

    public GetActivitiesDTO createSignup(CreateSignupDTO createSignupDTO) {
        Camper camper = camperRepository.findById(createSignupDTO.getCamper_id()).get();
        Activity activity = activityRepository.findById(createSignupDTO.getActivity_id()).get();
        Signup signup = mapper.map(createSignupDTO, Signup.class);
        signup.setCreated_at(new Date());
        signup.setActivity(activity);
        signup.setCamper(camper);
        signupRepository.save(signup);
        return mapper.map(activity, GetActivitiesDTO.class);
    }
}

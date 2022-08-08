package com.example.week7camperlab.service;

import com.example.week7camperlab.dto.CreateActivityDTO;
import com.example.week7camperlab.dto.GetActivitiesDTO;
import com.example.week7camperlab.model.Activity;
import com.example.week7camperlab.repository.ActivityRepository;
import com.example.week7camperlab.repository.SignupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    ModelMapper mapper;

    public GetActivitiesDTO createActivity(CreateActivityDTO createActivityDTO) {
       Activity activity = mapper.map(createActivityDTO, Activity.class);
       activity.setCreated_at(new Date());
       activity = activityRepository.save(activity);
       return mapper.map(activity, GetActivitiesDTO.class);
    }

    public List<GetActivitiesDTO> getActivities() {
        return activityRepository.findAll().stream().map(activity -> mapper.map(activity, GetActivitiesDTO.class)).collect(Collectors.toList());
    }

    public Activity getActivity(Integer activityId) {
        return activityRepository.findById(activityId).get();
    }
//
//    public void deleteActivity(Integer id) {
//        activityRepository.deleteById(id);
//    }
}

package com.example.week7camperlab.service;

import com.example.week7camperlab.model.Activity;
import com.example.week7camperlab.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivity(Integer activityId) {
        return activityRepository.findById(activityId).get();
    }

    public void deleteActivity(Integer id) {
        activityRepository.deleteById(id);
    }
}

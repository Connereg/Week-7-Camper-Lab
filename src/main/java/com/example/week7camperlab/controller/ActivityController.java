package com.example.week7camperlab.controller;

import com.example.week7camperlab.model.Activity;
import com.example.week7camperlab.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camp")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @PostMapping("/activities")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        Activity newActivity = activityService.createActivity(activity);
        return ResponseEntity.ok(newActivity);
    }

    @GetMapping("/activities")
    public List<Activity> readActivities() {
        return activityService.getActivities();
    }

    @DeleteMapping("/activities/{activityId}")
    public void deleteActivity(@PathVariable(value = "activityId") Integer id) {
        Activity retrivedActivity = activityService.getActivity(id);
        ResponseEntity.ok(retrivedActivity);
        activityService.deleteActivity(id);
    }
}

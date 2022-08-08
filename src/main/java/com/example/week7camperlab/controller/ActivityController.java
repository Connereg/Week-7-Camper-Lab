package com.example.week7camperlab.controller;

import com.example.week7camperlab.dto.CreateActivityDTO;
import com.example.week7camperlab.dto.GetActivitiesDTO;
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
    public GetActivitiesDTO createActivity(@RequestBody CreateActivityDTO createActivityDTO) {
        return activityService.createActivity(createActivityDTO);

    }

    @GetMapping("/activities")
    public List<GetActivitiesDTO> readActivities() {
        return activityService.getActivities();
    }

    @DeleteMapping("/activities/{activityId}")
    public void deleteActivity(@PathVariable(value = "activityId") Integer id) {
        activityService.getActivity(id);
    }
}

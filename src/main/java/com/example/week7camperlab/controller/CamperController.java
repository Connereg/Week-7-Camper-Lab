package com.example.week7camperlab.controller;

import com.example.week7camperlab.model.Camper;
import com.example.week7camperlab.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/camp")
public class CamperController {
    @Autowired
    CamperService camperService;

    @PostMapping("/campers")
    public ResponseEntity<Camper> createCamper(@RequestBody Camper camper) {
        Camper newCamper = camperService.createCamper(camper);
        newCamper.setCreated_at(new Date());
        return ResponseEntity.ok(newCamper);
    }

    @GetMapping("/campers")
    public List<Camper> readCampers() {
        return camperService.getCampers();
    }

    @GetMapping("/campers/{camperId}")
    public Camper readCamper(@PathVariable(value = "camperId") Integer id ) {
        return camperService.getCamper(id);

    }

    @PutMapping("/campers/{camperId}")
    public Camper updateCamper(@PathVariable(value = "camperId") Integer id, @RequestBody Camper camperData ) {
        camperData.setUpdated_at(new Date());
        return camperService.updateCamper(id, camperData);
    }

    @DeleteMapping("/campers/{camperId}")
    public void deleteCamper(@PathVariable(value = "camperId") Integer id) {
        camperService.deleteCamper(id);
    }

}

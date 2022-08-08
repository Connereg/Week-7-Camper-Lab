package com.example.week7camperlab.controller;

import com.example.week7camperlab.dto.CreateCamperDTO;
import com.example.week7camperlab.dto.GetCamperDTO;
import com.example.week7camperlab.dto.GetCampersDTO;
import com.example.week7camperlab.model.Camper;
import com.example.week7camperlab.service.CamperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/camp")
public class CamperController {
    @Autowired
    CamperService camperService;

    @PostMapping("/campers")
    public ResponseEntity<GetCampersDTO> createCamper(@Valid @RequestBody CreateCamperDTO createCamperDTO) {
        GetCampersDTO camperDTO = camperService.createCamper(createCamperDTO);
        return ResponseEntity.ok(camperDTO);
    }

    @GetMapping("/campers")
    public List<GetCampersDTO> readCampers() {
        return camperService.getCampers();
    }

    @GetMapping("/campers/{camperId}")
    public GetCamperDTO getCamper(@PathVariable(value = "camperId") Integer id ) {
        GetCamperDTO camperDTO = camperService.getCamper(id);
        return camperDTO;

    }

//    @PutMapping("/campers/{camperId}")
//    public Camper updateCamper(@PathVariable(value = "camperId") Integer id, @RequestBody Camper camperData ) {
//        return camperService.updateCamper(id, camperData);
//    }
//
//    @DeleteMapping("/campers/{camperId}")
//    public void deleteCamper(@PathVariable(value = "camperId") Integer id) {
//        camperService.deleteCamper(id);
//    }



}

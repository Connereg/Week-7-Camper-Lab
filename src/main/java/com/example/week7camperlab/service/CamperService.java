package com.example.week7camperlab.service;

import com.example.week7camperlab.dto.CreateCamperDTO;
import com.example.week7camperlab.dto.GetActivitiesDTO;
import com.example.week7camperlab.dto.GetCamperDTO;
import com.example.week7camperlab.dto.GetCampersDTO;
import com.example.week7camperlab.model.Activity;
import com.example.week7camperlab.model.Camper;
import com.example.week7camperlab.model.Signup;
import com.example.week7camperlab.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CamperService {
    @Autowired
    CamperRepository camperRepository;

    @Autowired
    ModelMapper mapper;


    public GetCampersDTO createCamper(CreateCamperDTO createCamperDTO) {
        Camper camper = mapper.map(createCamperDTO, Camper.class);
        // Create Camper with DTO values
        camper.setCreated_at(new Date());
        camper = camperRepository.save(camper);
        return mapper.map(camper, GetCampersDTO.class);
    }

    public List<GetCampersDTO> getCampers() {

        return camperRepository.findAll().stream().map(camper -> mapper.map(camper, GetCampersDTO.class)).collect(Collectors.toList());
    }

    public GetCamperDTO getCamper(Integer camperId) {

        Optional<Camper> optionalCamper = camperRepository.findById(camperId);
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND), "Camper not Found");
        if (!optionalCamper.isPresent())  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Camper not Found");
        }
        Camper camper = optionalCamper.get();
        GetCamperDTO camperDTO = mapper.map(camper, GetCamperDTO.class);
        List<Signup> signups = camper.getSignupList();
        List<Activity> activities = new ArrayList<>();
        for (Signup signup : signups) {
            Activity activity = signup.getActivity();
            activities.add(activity);
        }
        for(int i = 0; i < activities.size(); i++) {
            GetActivitiesDTO activityDTO = mapper.map(activities.get(i), GetActivitiesDTO.class);
            camperDTO.addActivityDTO(activityDTO);
        }
        return camperDTO;
    }

//    public Camper updateCamper(Integer id, Camper camperData) {
//        Camper updatedCamper = camperRepository.findById(id).get();
//        updatedCamper.setName(camperData.getName());
//        updatedCamper.setAge(camperData.getAge());
//        return camperRepository.save(updatedCamper);
//    }
//
//    public void deleteCamper(Integer id) {
//       camperRepository.deleteById(id);
//    }

}


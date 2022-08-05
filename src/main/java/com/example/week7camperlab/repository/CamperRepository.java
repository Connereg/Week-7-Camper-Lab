package com.example.week7camperlab.repository;

import com.example.week7camperlab.model.Camper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CamperRepository extends JpaRepository<Camper, Integer> {
}

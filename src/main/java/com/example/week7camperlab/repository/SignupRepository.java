package com.example.week7camperlab.repository;

import com.example.week7camperlab.model.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<Signup, Integer> {
}
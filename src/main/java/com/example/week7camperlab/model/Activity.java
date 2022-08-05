package com.example.week7camperlab.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;
    @NotNull
    private int difficulty;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "activity")
    private List<Signup> signupList = new ArrayList<>();



}

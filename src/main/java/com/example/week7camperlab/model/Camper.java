package com.example.week7camperlab.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Camper {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @Min(value = 8)
    @Max(18)
    private int age;
    private Date created_at;
    private Date updated_at;

    @OneToMany(mappedBy = "camper")
    private List<Signup> signupList = new ArrayList<>();

    public void setCreated_at(Date date) {
        this.created_at = date;
    }

    public void setUpdated_at(Date date) {
        this.updated_at = date;
    }
}

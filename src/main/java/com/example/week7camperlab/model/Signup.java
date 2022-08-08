package com.example.week7camperlab.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Getter
@Setter
@Entity
public class Signup {
    @Id
    @GeneratedValue
    private int id;

    @Min(value = 0)
    @Max(23)
    private int time;
    private Date created_at;
    private Date updated_at;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private Camper camper;


}

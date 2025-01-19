package com.carewell.Hospital;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String phone;
   private String image;
    private String experience;
    private String education;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    @JsonIgnore
    private HospitalEntity hospital;
}


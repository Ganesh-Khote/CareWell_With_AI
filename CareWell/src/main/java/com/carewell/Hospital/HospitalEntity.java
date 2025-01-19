package com.carewell.Hospital;

import java.util.List;

import com.carewell.UserType;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="hospital")
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String email;
    String password;
    String speciality;
    String address;
    String phone;
    String image;

    @OneToMany(mappedBy = "hospital")
    List<DoctorEntity> doctors;

   

    UserType userType;

    public void addDoctor(DoctorEntity doctor) {
        doctor.setHospital(this);
        this.doctors.add(doctor);
    }
}

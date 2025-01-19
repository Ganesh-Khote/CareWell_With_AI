package com.carewell.dto;

import com.carewell.UserType;

import lombok.Data;
@Data
public class HospitalDto {

    String name;
    String email;
    String password;
    String speciality;
    String address;
    String phone;
    UserType userType;
}

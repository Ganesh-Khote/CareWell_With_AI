package com.carewell.dto;

import com.carewell.UserType;

import lombok.Data;

@Data
public class MedicalDto {

    String name;
    String phone;
    String email;
    String password;
    String address;
    UserType userType;

}

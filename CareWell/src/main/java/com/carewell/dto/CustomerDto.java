package com.carewell.dto;

import com.carewell.UserType;

import lombok.Data;
@Data
public class CustomerDto {
    Long id;
    String name;
    String email;
    String password;
    int age;
    String address;
    String gender;
    String phone;
    UserType usertype;

}

package com.carewell.dto;

// import com.carewell.UserType;

import lombok.Data;
@Data
public class LoginDto {
    String email;
    String password;
    String userType;
}

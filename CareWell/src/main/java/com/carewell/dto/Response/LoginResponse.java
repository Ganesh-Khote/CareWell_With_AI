package com.carewell.dto.Response;

import lombok.Data;

@Data
public class LoginResponse {

    String message;
    String token;

    public LoginResponse(String message, String token2) {
       this.message=message;
       this.token=token2;
    }
   
}

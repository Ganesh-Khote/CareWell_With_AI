package com.carewell.Controller;

// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.carewell.dto.LoginDto;
import com.carewell.dto.Response.LoginResponse;

import com.carewell.services.customer.Customerserviceinterface;
import com.carewell.services.hospital.HospitalService;
import com.carewell.services.medical.MedicalService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    Customerserviceinterface customerservice;
    @Autowired
    HospitalService hospitalService;
    @Autowired
    MedicalService medicalService;

  @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
    String userType = loginDto.getUserType();
    String email = loginDto.getEmail();
    String password = loginDto.getPassword();

    switch (userType.toLowerCase()) {
        case "customer":
            String customertoken = customerservice.login(email, password);
            if (customertoken != null) {
                return ResponseEntity.ok(new LoginResponse("Customer Login Successful", customertoken));
            }
            break;

        case "hospital":
            String token = hospitalService.login(email, password);
            if (token != null) {
                return ResponseEntity.ok(new LoginResponse("Hospital Login Successful",token));
            }
            break;

        case "medical":
            String medicaltoken = medicalService.login(email, password);
            if (medicaltoken != null) {
                return ResponseEntity.ok(new LoginResponse("Medical Login Successfully", medicaltoken));
               
               
            }
            break;

        default:
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid User Type");
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
}

}

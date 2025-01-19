package com.carewell.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carewell.Hospital.HospitalEntity;
import com.carewell.customer.CustomerEntity;
import com.carewell.dto.CustomerDto;
import com.carewell.dto.HospitalDto;
import com.carewell.dto.MedicalDto;
import com.carewell.medical.MedicalsEntity;
import com.carewell.services.customer.Customerserviceinterface;
import com.carewell.services.hospital.HospitalService;
import com.carewell.services.medical.MedicalService;

@RestController
@RequestMapping("/register")
public class Registration {

    @Autowired
    Customerserviceinterface customerservice;
    @Autowired
    HospitalService hospitalService;
    @Autowired
    MedicalService medicalService;

    @PostMapping("/customer")
    public ResponseEntity<?> customerRegisteration(@RequestBody CustomerDto customerdto){
        CustomerEntity CreatedUser=customerservice.register(customerdto);
        if(CreatedUser!=null){

            return ResponseEntity.status(HttpStatus.CREATED).body("Customer Register Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PostMapping("/hospital")
    public ResponseEntity<?> hospitalRegisteration(@RequestBody HospitalDto hospitalDto){
        HospitalEntity Created=hospitalService.register(hospitalDto);
        if(Created!=null){

            return ResponseEntity.status(HttpStatus.CREATED).body("Hospital Register Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PostMapping("/medical")
    public ResponseEntity<?> medicalRegisteration(@RequestBody MedicalDto medicalDto){
        MedicalsEntity Created=medicalService.register(medicalDto);
        if(Created!=null){

            return ResponseEntity.status(HttpStatus.CREATED).body("Medical Register Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}

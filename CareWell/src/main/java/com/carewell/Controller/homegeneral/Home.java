package com.carewell.Controller.homegeneral;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carewell.Hospital.HospitalEntity;
import com.carewell.medical.MedicalsEntity;
import com.carewell.services.hospital.activity.HospitalactivityService;
import com.carewell.services.medical.MedicalService;

@RestController
@RequestMapping("")
public class Home {

    @Autowired
    HospitalactivityService hospitalservice;

    @Autowired
    MedicalService medicalService;

    @GetMapping("/gethospitals")
public List<HospitalEntity> getHospitals(){
    List<HospitalEntity> hospitals=hospitalservice.getHospitals();
    return hospitals;
}

@GetMapping("/gethospitals/{id}")
public Optional<HospitalEntity> gethospital(@PathVariable Long id){
    Optional<HospitalEntity> hospital=hospitalservice.gethospitalbyid(id);
    return hospital;
}

@GetMapping("/getmedicals")
public List<MedicalsEntity> getmedicals(){
    List<MedicalsEntity> medicals=medicalService.getmedicals();
    return medicals;
}


}

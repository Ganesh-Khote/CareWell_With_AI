package com.carewell.services.hospital.activity;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carewell.Hospital.DoctorEntity;
import com.carewell.Hospital.HospitalEntity;

@Service
public interface HospitalactivityService {
    public void saveHospitalImage(Long id,String imagePath);
    public DoctorEntity addDoctor(Long HospitalId,DoctorEntity doctor);
    public List<HospitalEntity> getHospitals();
    public Optional<HospitalEntity> gethospitalbyid(Long id);

}

package com.carewell.services.medical;

import java.util.List;

// import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carewell.dto.MedicalDto;
import com.carewell.medical.MedicalsEntity;

@Service
public interface MedicalService {

    public MedicalsEntity register(MedicalDto medicalDto);
    public String login(String email,String password);
    public List<MedicalsEntity> getmedicals();

}

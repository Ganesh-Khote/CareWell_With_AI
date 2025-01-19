package com.carewell.services.hospital;

// import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carewell.Hospital.HospitalEntity;
import com.carewell.dto.HospitalDto;

@Service
public interface HospitalService {
    public HospitalEntity register(HospitalDto hospitalDto);
    public String login(String email,String password);
}

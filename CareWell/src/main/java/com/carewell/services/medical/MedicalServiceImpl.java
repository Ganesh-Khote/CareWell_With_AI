package com.carewell.services.medical;

import java.util.List;

// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carewell.UserType;
import com.carewell.AuthJwt.JwtUtils;
import com.carewell.Repository.medical.MedicalRepoAuthinterface;
import com.carewell.dto.MedicalDto;
import com.carewell.medical.MedicalsEntity;

@Service
public class MedicalServiceImpl implements MedicalService{

    @Autowired
    MedicalRepoAuthinterface medicalRepoAuthinterface;

    @Override
    public MedicalsEntity register(MedicalDto medicalDto) {

        MedicalsEntity existingMedical=medicalRepoAuthinterface.findByEmail(medicalDto.getEmail());
        if(existingMedical!=null){
            throw new IllegalArgumentException("Medical Are Already Exist"+medicalDto.getEmail());
        }

        MedicalsEntity medicalsEntity=new MedicalsEntity();
        medicalsEntity.setEmail(medicalDto.getEmail());
        medicalsEntity.setPassword(medicalDto.getPassword());
        medicalsEntity.setAddress(medicalDto.getAddress());
        medicalsEntity.setName(medicalDto.getName());
        medicalsEntity.setPhone(medicalDto.getPhone());
        medicalsEntity.setUserType(UserType.MEDICALS);
        return medicalRepoAuthinterface.save(medicalsEntity);
    }

    JwtUtils jwtUtils=new JwtUtils();

    @Override
    public String login(String email, String password) {
        MedicalsEntity medical=medicalRepoAuthinterface.findByEmail(email);
        if(medical!=null && medical.getPassword().equals(password)){

            return this.jwtUtils.generateToken(medical.getId());
        }
        throw new IllegalArgumentException("Medical With This Username Is Not Found!! : "+email);
    }

    public List<MedicalsEntity> getmedicals(){
        List<MedicalsEntity> medicals=medicalRepoAuthinterface.findAll();
        return medicals;
    } 


}

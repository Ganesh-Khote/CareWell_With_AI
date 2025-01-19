package com.carewell.services.hospital;

// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carewell.UserType;
import com.carewell.AuthJwt.JwtUtils;
import com.carewell.Hospital.HospitalEntity;
import com.carewell.Repository.hospital.HospitalRepoAuthinterface;
import com.carewell.dto.HospitalDto;

@Service
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    HospitalRepoAuthinterface hospitalRepoAuthinterface;

   JwtUtils jwtUtils=new JwtUtils();
    @Override
    public HospitalEntity register(HospitalDto hospitalDto) {
        HospitalEntity existinghospital=hospitalRepoAuthinterface.findByEmail(hospitalDto.getEmail());
        if(existinghospital!=null){
            throw new IllegalArgumentException("Hospital Already Exist"+hospitalDto.getEmail());
        }
      HospitalEntity entity=new HospitalEntity();
       entity.setName(hospitalDto.getName());
       entity.setEmail(hospitalDto.getEmail());
       entity.setPassword(hospitalDto.getPassword());
       entity.setSpeciality(hospitalDto.getSpeciality());
       entity.setPhone(hospitalDto.getPhone());
       entity.setAddress(hospitalDto.getAddress());
       entity.setUserType(UserType.HOSPITAL);
       return hospitalRepoAuthinterface.save(entity);
       
    }

    @Override
    public String login(String email, String password) {
      HospitalEntity User=hospitalRepoAuthinterface.findByEmail(email);
      if(User!=null&& User.getPassword().equals(password)){
        return this.jwtUtils.generateToken(User.getId());
      }
         throw new IllegalArgumentException("Hospital Not Fouund!!") ;
    }

}

package com.carewell.services.hospital.activity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carewell.Hospital.DoctorEntity;
import com.carewell.Hospital.HospitalEntity;
import com.carewell.Repository.hospital.HospitalRepoAuthinterface;

@Service
public class HospitalAcivityServiceImpl implements HospitalactivityService {

    @Autowired
    HospitalRepoAuthinterface hospitalRepoAuthinterface;

    HospitalEntity entity=new HospitalEntity();

    @Override
    public void saveHospitalImage(Long id, String imagePath) {
        HospitalEntity image=hospitalRepoAuthinterface.findById(id).orElseThrow(()-> new RuntimeException("Hospital Not Found"));
        image.setImage(imagePath);
        hospitalRepoAuthinterface.save(image);
    }

    @Override
    public DoctorEntity addDoctor(Long HospitalId, DoctorEntity doctor) {
       HospitalEntity hospital=hospitalRepoAuthinterface.findById(HospitalId).orElseThrow();
       hospital.addDoctor(doctor);
       hospitalRepoAuthinterface.save(hospital);
       return doctor;
    }

    public List<HospitalEntity> getHospitals(){
      List<HospitalEntity> hospital=this.hospitalRepoAuthinterface.findAll();
      return hospital;
    }

    public Optional<HospitalEntity> gethospitalbyid(Long id){
       Optional<HospitalEntity> hospital=this.hospitalRepoAuthinterface.findById(id);
        return hospital;
    }

}

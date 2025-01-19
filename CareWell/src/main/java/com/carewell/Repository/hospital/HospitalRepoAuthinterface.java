package com.carewell.Repository.hospital;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carewell.Hospital.HospitalEntity;

@Repository
public interface HospitalRepoAuthinterface extends JpaRepository<HospitalEntity,Long>{
    public HospitalEntity findByEmail(String email);
}

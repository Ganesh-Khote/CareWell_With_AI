package com.carewell.Repository.medical;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carewell.medical.MedicalsEntity;

@Repository
public interface MedicalRepoAuthinterface extends JpaRepository<MedicalsEntity,Long>{
    public MedicalsEntity findByEmail(String email);
}

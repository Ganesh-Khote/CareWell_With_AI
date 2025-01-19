package com.carewell.Repository.customer;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carewell.customer.CustomerEntity;

@Repository
public interface CustomerRepoAuthinterface extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByEmail(String email);
}

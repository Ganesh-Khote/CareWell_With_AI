package com.carewell.services.customer;

// import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carewell.customer.CustomerEntity;
import com.carewell.dto.CustomerDto;

@Service
public interface Customerserviceinterface {
    public CustomerEntity register(CustomerDto customerDto);
    public String login(String email,String password);
}

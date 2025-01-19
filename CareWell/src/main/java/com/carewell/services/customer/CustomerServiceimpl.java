package com.carewell.services.customer;

// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carewell.UserType;
import com.carewell.AuthJwt.JwtUtils;
import com.carewell.Repository.customer.CustomerRepoAuthinterface;
import com.carewell.customer.CustomerEntity;
import com.carewell.dto.CustomerDto;

@Service
public class CustomerServiceimpl implements Customerserviceinterface {

    @Autowired
    CustomerRepoAuthinterface customerRepo;

    JwtUtils jwtUtils=new JwtUtils();

    public String login(String email,String password){
       CustomerEntity customer=customerRepo.findByEmail(email);
       if(customer!=null && customer.getPassword().equals(password)){
        return this.jwtUtils.generateToken(customer.getId());
       }
       throw new IllegalArgumentException("UserNot Found with"+email);
    }

    

    @Override
    public CustomerEntity register(CustomerDto customerDto) {
      
      CustomerEntity ExistingCustomer=customerRepo.findByEmail(customerDto.getEmail());
      if(ExistingCustomer!=null){
        throw new IllegalArgumentException("Customer Already Register With This Email"+customerDto.getEmail()) ;
      }
      CustomerEntity customer=new CustomerEntity();
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setName(customerDto.getName());
        customer.setAge(customerDto.getAge());
        customer.setAddress(customerDto.getAddress());
        customer.setGender(customerDto.getGender());
        customer.setPhone(customerDto.getPhone());
        customer.setUserType(UserType.CUSTOMER);
      return customerRepo.save(customer);
    }
}

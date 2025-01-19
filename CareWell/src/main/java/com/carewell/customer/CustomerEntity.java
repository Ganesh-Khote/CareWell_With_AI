package com.carewell.customer;

import com.carewell.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="customer")
@Data
public class CustomerEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
Long id;

String name;
String gender;
String email;
String phone;
int age;
String password;
String address;
UserType userType;

}

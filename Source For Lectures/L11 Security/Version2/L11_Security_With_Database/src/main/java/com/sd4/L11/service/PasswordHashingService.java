package com.sd4.L11.service;

import com.sd4.L11.entitys.Customer;
import com.sd4.L11.repo.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PasswordHashingService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void hashExistingPasswords() {
        //get all users
        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            String plainTextPassword = customer.getPassword();
            //Check if the password is already hashed (BCrypt hashes start with $2a$)
            if (!plainTextPassword.startsWith("$2a$")) {
                //Hash the plain text password
                String hashedPassword = passwordEncoder.encode(plainTextPassword);
                customer.setPassword(hashedPassword);
                //Update the database with the hashed pwd
                customerRepository.save(customer);
            }
        }
    }
}

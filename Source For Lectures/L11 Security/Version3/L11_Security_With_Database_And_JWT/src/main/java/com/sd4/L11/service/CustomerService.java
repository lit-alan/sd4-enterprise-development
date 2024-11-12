package com.sd4.L11.service;

import com.sd4.L11.entitys.Customer;
import com.sd4.L11.entitys.Role;
import com.sd4.L11.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService  implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    /*
    This method loads a user by their email, retrieves their roles from the database,
    converts them into authorities, and returns a UserDetails object with the user’s
    credentials and roles for Spring Security authentication.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //retrieve a customer account from the DB by email address
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + email));

        /*
        Get a list of all the roles associated with the Customer and convert
        them into a list of GrantedAuthority objects.
        If the authenticated user has two roles, then there will be two GrantedAuthority objects
        in this list etc..
         */
        List<GrantedAuthority> authorities = customer.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

        //Log the authorities to the console to verify they are being assigned
        System.out.println("Granted Authorities: " + authorities);

        //Create and return a new instance of User, this is a class provided by Spring
        //Security that implements the UserDetails interface
        return new org.springframework.security.core.userdetails.User(
                customer.getEmail(), //the username in our app
                customer.getPassword(), //the hashed pwd
                //four boolean values for user account status to indicate whether the account is
                true, //enabled
                true, //not expired
                true, //credentials are not expired
                true, //account it not locked
                authorities
        );
    }

    /*
    This method converts a set of Role objects into a collection of GrantedAuthority
    objects prefixed with "ROLE_" for use in authorisation.
    */
    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

        }
        return authorities;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }
}

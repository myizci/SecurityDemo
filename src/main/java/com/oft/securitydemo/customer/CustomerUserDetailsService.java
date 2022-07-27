package com.oft.securitydemo.customer;

import com.oft.securitydemo.admin.CustomUserDetails;
import com.oft.securitydemo.admin.User;
import com.oft.securitydemo.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository repo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Customer customer= repo.findByEmail(username);
       if(customer==null){
           throw  new UsernameNotFoundException("No user with the email "+username);
       }
        return new CustomerUserDetails(customer);

    }
}

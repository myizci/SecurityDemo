package com.oft.securitydemo;

import com.oft.securitydemo.admin.User;
import com.oft.securitydemo.admin.UserRepository;
import com.oft.securitydemo.customer.Customer;
import com.oft.securitydemo.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DatabaseLoader {

    private final UserRepository userRepo;
    private final CustomerRepository customerRepo;

    @Bean
    public CommandLineRunner initializeDatabase(){
        return args -> {
            User user1= new User("admin@oft.net", "admin123");
            User user2= new User("admin2@oft.net", "admin123");

            userRepo.saveAll(List.of(user1,user2));

            Customer customer1 = new Customer("customer1@oft.net","customer123","Customer One");
            Customer customer2 = new Customer("customer2@oft.net","customer123","Customer Two");

            customerRepo.saveAll(List.of(customer1,customer2));

            System.out.println("sample database initialized");
        };
    }

}

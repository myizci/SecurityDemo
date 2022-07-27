package com.oft.securitydemo;

import com.oft.securitydemo.admin.User;
import com.oft.securitydemo.admin.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DatabaseLoader {

    private final UserRepository repo;

    @Bean
    public CommandLineRunner initializeDatabase(){
        return args -> {
            User user1= new User("admin@oft.net", "admin123");
            User user2= new User("admin2@oft.net", "admin123");


            repo.saveAll(List.of(user1,user2));

            System.out.println("sample database initialized");
        };
    }

}

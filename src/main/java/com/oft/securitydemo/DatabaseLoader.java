package com.oft.securitydemo;

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
            User user1= new User("admin@oft.net", "admin123",Role.ADMIN);
            User user2= new User("admin2@oft.net", "admin123",Role.ADMIN);
            User user3= new User("user1@oft.net", "user123",Role.USER);
            User user4= new User("user2@oft.net", "user123",Role.USER);

            repo.saveAll(List.of(user1,user2,user3,user4));

            System.out.println("sample database initialized");
        };
    }

}

package com.oft.securitydemo.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@Order(2)
public class CustomerSecurityConfig {





        @Bean
        public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {


            http.antMatcher("/user/**").authorizeRequests().anyRequest().hasAuthority("USER")
                    .and()
                    .formLogin()
                    .loginPage("/user/login")
                    .usernameParameter("email")
                    .loginProcessingUrl("/user/login")
                    .defaultSuccessUrl("/user/home")
                    .permitAll()
                    .and()
                    .logout().logoutUrl("user/logout")
                    .logoutSuccessUrl("/");

            return http.build();

        }
}

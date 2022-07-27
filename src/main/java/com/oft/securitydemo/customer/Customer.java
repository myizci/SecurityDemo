package com.oft.securitydemo.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false, length = 40)
    private String email;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(unique = true, nullable = false, length = 40)
    private String fullName;


    public Customer(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }
}

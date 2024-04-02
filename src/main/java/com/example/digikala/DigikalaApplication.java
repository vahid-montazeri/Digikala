package com.example.digikala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DigikalaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigikalaApplication.class, args);


    }





}

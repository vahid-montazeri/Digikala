package com.example.digikala;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DIGIKALApplication {

    public static void main(String[] args) {
        SpringApplication.run(DIGIKALApplication.class, args);

        Faker faker = new Faker();

    }





}

package com.example.demo_homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DemoHomepageApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoHomepageApplication.class, args);
    }

}

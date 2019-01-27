package com.zagwork.test.interest.microservice.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan({"com.zagwork.test.interest.microservice"})
@PropertySource("classpath:application.properties")
public class ApplicationStarter {

    public static void main(final String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
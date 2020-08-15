package com.czxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AcceptAppcation {
    public static void main(String[] args) {
        SpringApplication.run(AcceptAppcation.class,args);
    }
}

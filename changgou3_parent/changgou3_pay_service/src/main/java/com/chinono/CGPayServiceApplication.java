package com.chinono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CGPayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CGPayServiceApplication.class,args);
    }
}

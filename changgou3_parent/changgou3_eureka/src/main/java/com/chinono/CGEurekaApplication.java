package com.chinono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CGEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CGEurekaApplication.class,args);
    }
}

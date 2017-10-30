package com.weproud.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class ApiUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiUserServiceApplication.class, args);
    }

    @RequestMapping("/user")
    public String discovery() {
        return "Hello from User Api service";
    }
}

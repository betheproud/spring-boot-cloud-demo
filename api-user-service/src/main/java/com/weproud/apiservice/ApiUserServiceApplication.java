package com.weproud.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ApiUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiUserServiceApplication.class, args);
    }

    @RequestMapping("/message")
    public String message() {
        return "Hello from Api User service";
    }
}

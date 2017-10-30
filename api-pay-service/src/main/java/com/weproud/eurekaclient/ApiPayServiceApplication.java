package com.weproud.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class ApiPayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPayServiceApplication.class, args);
    }

    @RequestMapping("/pay")
    public String pay() {
        return "Hello from Pay Api service";
    }
}

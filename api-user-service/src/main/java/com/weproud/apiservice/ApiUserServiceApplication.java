package com.weproud.apiservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ApiUserServiceApplication implements CommandLineRunner {

    @Value("${config-service.test}")
    private String configServiceMessage;

    public static void main(String[] args) {
        SpringApplication.run(ApiUserServiceApplication.class, args);
    }

    @RequestMapping("/message")
    public String message() {
        return "Hello from Api User service";
    }

    @Override
    public void run(final String... args) throws Exception {
        log.info("config-service is working: {}", this.configServiceMessage);
    }
}

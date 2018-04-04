package com.weproud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApiUserServiceApplication implements CommandLineRunner {

    @Autowired
    private Environment environment;

    @Value("${config-service.test}")
    private String configServiceMessage;

    public static void main(String[] args) {
        SpringApplication.run(ApiUserServiceApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello from Api User service on "
                + this.environment.getProperty("spring.cloud.client.ipAddress")
                + ":" + this.environment.getProperty("local.server.port");
    }

    @RequestMapping("/auth")
    public ResponseEntity hello(Principal principal) {

        return new ResponseEntity<>(principal, HttpStatus.OK);
    }

    @Override
    public void run(final String... args) throws Exception {
        log.info("config-service is working: {}", this.configServiceMessage);
    }
}

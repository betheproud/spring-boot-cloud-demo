package com.weproud.eurekaclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ApiPayServiceApplication implements CommandLineRunner {

    @Value("${config-service.test}")
    private String configServiceMessage;

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ApiPayServiceApplication.class, args);
    }

    @RequestMapping("/message")
    public String message() {
        return "Hello from Api Pay service";
    }

    @GetMapping("/")
    public String consumer() {
        String result = this.restTemplate.getForObject("http://api-user-service:8082/message", String.class);
        log.info("result: {}", result);
        return result;
    }

    @Override
    public void run(final String... args) throws Exception {
        log.info("config-service is working: {}", this.configServiceMessage);
    }
}

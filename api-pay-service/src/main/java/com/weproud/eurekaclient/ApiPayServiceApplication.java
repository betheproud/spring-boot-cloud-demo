package com.weproud.eurekaclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@EnableEurekaClient
@SpringBootApplication
public class ApiPayServiceApplication {
    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ApiPayServiceApplication.class, args);
    }

    @RequestMapping("/message")
    public String message() {
        return "Hello from Api Pay service";
    }

    @GetMapping("/consumer")
    public String consumer() {
        String result = this.restTemplate.getForObject("http://localhost:8082/message", String.class);
        log.debug("result: {}", result);
        return result;
    }
}

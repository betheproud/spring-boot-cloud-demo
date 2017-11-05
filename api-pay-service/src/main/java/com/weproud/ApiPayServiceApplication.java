package com.weproud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ApiPayServiceApplication implements CommandLineRunner {

    @Autowired
    private Environment environment;

    @Value("${config-service.test}")
    private String configServiceMessage;

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ApiPayServiceApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello from Api Pay service on "
                + this.environment.getProperty("spring.cloud.client.ipAddress")
                + ":" + this.environment.getProperty("local.server.port");
    }

    @GetMapping("/client")
    public String client() {
        String result = this.restTemplate.getForObject("http://localhost:8082/message", String.class);
        log.info("result: {}", result);
        return result;
    }

    @Override
    public void run(final String... args) throws Exception {
        log.info("config-service is working: {}", this.configServiceMessage);
    }
}

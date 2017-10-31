package com.weproud.eurekaserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServiceApplication implements CommandLineRunner {

    @Value("${config-service.test}")
    private String configServiceMessage;

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        log.info("config-service is working: {}", this.configServiceMessage);
    }
}

package com.weproud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;


@EnableZipkinServer
@EnableDiscoveryClient
@SpringBootApplication
public class TraceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraceServiceApplication.class, args);
    }
}

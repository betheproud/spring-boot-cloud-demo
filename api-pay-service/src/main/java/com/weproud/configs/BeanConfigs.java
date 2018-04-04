package com.weproud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Logan. k
 */
@Configuration
public class BeanConfigs {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public AlwaysSampler alwaysSampler() {
//        return new AlwaysSampler();
//    }
}

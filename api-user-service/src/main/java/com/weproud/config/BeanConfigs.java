package com.weproud.config;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Logan. k
 */
@Configuration
public class BeanConfigs {
    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }
}

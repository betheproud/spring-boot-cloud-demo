package com.weproud.configs;

import com.weproud.notify.TelegramNotifier;
import de.codecentric.boot.admin.config.NotifierConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Logan. k
 */
@Slf4j
@Configuration
public class ConditionalBeans {
    @Configuration
    @ConditionalOnProperty(prefix = "spring.boot.admin.notify.telegram", name = "bot-token")
    @AutoConfigureBefore({NotifierConfiguration.NotifierListenerConfiguration.class,
            NotifierConfiguration.CompositeNotifierConfiguration.class})
    public static class TelegramNotifierConfiguration {
        @Bean
        @ConditionalOnMissingBean
        @ConfigurationProperties(prefix = "spring.boot.admin.notify.telegram")
        public TelegramNotifier telegramNotifier() {
            return new TelegramNotifier();
        }
    }
}

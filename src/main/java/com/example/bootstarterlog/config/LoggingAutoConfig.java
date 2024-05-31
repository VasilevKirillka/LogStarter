package com.example.bootstarterlog.config;

import com.example.bootstarterlog.aspest.LogAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Класс конфигурации, который используется для настройки логирования.
 * Проверить значение свойства logging-request.enabled для включени/отключения конфигурации
 */
@Configuration
@EnableConfigurationProperties(LoggingProperties.class)
@ConditionalOnProperty(prefix = "logging-request", value = "enabled", havingValue = "true", matchIfMissing = false)
public class LoggingAutoConfig {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}

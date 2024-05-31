package com.example.bootstarterlog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Класс, содержащий свойства конфигурации для логирования
 */
@ConfigurationProperties(prefix = "logging-request")
@Getter
@Setter
public class LoggingProperties {

    private Boolean enabled;

}

package com.example.bootstarterlog.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * Класс для инициализацию контекста приложения
 */

@Slf4j
public class LogAppContextInit implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("Вызов LogAppContextInit");
    }
}

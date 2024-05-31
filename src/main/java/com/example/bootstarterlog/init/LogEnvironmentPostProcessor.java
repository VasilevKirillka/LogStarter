package com.example.bootstarterlog.init;

import com.example.bootstarterlog.logException.LogStartException;
import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.logging.DeferredLogFactory;
import org.springframework.core.env.ConfigurableEnvironment;

public class LogEnvironmentPostProcessor implements EnvironmentPostProcessor {
    private final Log log;

    public LogEnvironmentPostProcessor(DeferredLogFactory logFactory) {
        this.log = logFactory.getLog(LogEnvironmentPostProcessor.class);
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        log.info("Вызов LogEnvironmentPostProcessor");

        String enabledPropertyValues = environment.getProperty("logging-request.enabled");

        boolean isBoolValue = Boolean.TRUE.toString().equals(enabledPropertyValues) ||
                Boolean.FALSE.toString().equals(enabledPropertyValues);

        if (!isBoolValue) {
            throw new LogStartException("Ошибка при проверке свайства \"logging-request.enabled\"");
        }
    }
}

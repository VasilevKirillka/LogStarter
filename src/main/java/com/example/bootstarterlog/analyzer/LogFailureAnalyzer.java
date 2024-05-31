package com.example.bootstarterlog.analyzer;

import com.example.bootstarterlog.logException.LogStartException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * Класс анализатора ошибок, который анализирует исключение типа LogStartException
 * и создает соответствующий анализ ошибки.
 */
public class LogFailureAnalyzer extends AbstractFailureAnalyzer<LogStartException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, LogStartException cause) {
        return new FailureAnalysis(cause.getMessage(), "Укажите валидные значения для свойств",
                cause);
    }
}

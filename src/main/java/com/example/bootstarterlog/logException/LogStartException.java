package com.example.bootstarterlog.logException;

/**
 * Исключение, которое может быть выброшено при ошибке старта логирования
 */
public class LogStartException extends RuntimeException {

    public LogStartException(String message) {
        super(message);
    }
}

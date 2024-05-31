package com.example.bootstarterlog.aspest;

import com.example.bootstarterlog.annotation.LoggingRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Enumeration;


@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * Аспект логирования, который записывает информацию о вызове метода и его результате.
     *
     * @param joinPoint      Точка присоединения, представляющая вызов метода.
     * @param loggingRequest Аннотация, указывающая на необходимость логирования запроса.
     * @return Результат выполнения метода.
     */
    @Around("@annotation(loggingRequest)")
    public Object loggingAspect(ProceedingJoinPoint joinPoint, LoggingRequest loggingRequest) {
        long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodsArgs = joinPoint.getArgs();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString();
        try {
            Object result = joinPoint.proceed();
            log.info("Запуск метода: '{}', аргументы: '{}', URL: '{}'", methodName, Arrays.toString(methodsArgs), url);
            log.info("Заголовки запроса:");
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                log.info("{}: {}", headerName, request.getHeader(headerName));
            }
            long endTime = System.currentTimeMillis() - startTime;
            if (result instanceof ResponseEntity<?> responseEntity) {
                log.info("Заголовки ответа:");
                log.info("Метод: {}", methodName);
                log.info("Время выполнения: {} мс", endTime);
                log.info("Статус ответа: {}", responseEntity.getStatusCode());
                log.info("Тело ответа: {}", responseEntity.getBody());
            }
            return result;
        } catch (Throwable e) {
            log.error("Ошибка '{}' при выволнении метода '{}' c аргументами '{}'", e.getMessage(), methodName, methodsArgs);
            throw new RuntimeException(e.getMessage());
        }
    }

}

package com.lcwd.Hotel.Service.HotelService.helper;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * LoggingAspect class provides logging for all methods inside controller package.
 * It logs method execution before and after they run, capturing input parameters and response details.
 */
@Aspect // Declares this class as an Aspect (for Aspect-Oriented Programming)
@Component // Registers this class as a Spring Bean
@Slf4j // Enables logging using SLF4J
public class LoggingAspect {

    /**
     * Pointcut to match execution of any method in the controller package.
     */
    @Pointcut("execution(* com.lcwd.Hotel.Service.HotelService.controller.*.*(..))")
    public void logForControllerExecution() {
        // Pointcut definition - No logic here
    }

    /**
     * Logs method execution details before the method is invoked.
     *
     * @param joinPoint provides metadata about the intercepted method.
     */
    @Before("logForControllerExecution()")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        log.info("Method execution started: {}", joinPoint.getSignature().getName()); // Logs method name
        log.info("Parameters: {}", Arrays.toString(joinPoint.getArgs())); // Logs method arguments
        log.info("Class: {}", joinPoint.getTarget().getClass().getName()); // Logs class name
    }

    /**
     * Logs method execution details after the method completes successfully.
     *
     * @param joinPoint provides metadata about the intercepted method.
     * @param result captures the response returned by the method.
     */
    @AfterReturning(pointcut = "logForControllerExecution()", returning = "result")
    public <T> void afterMethodExecution(JoinPoint joinPoint, ResponseEntity<T> result) {
        log.info("Method execution completed: {}", joinPoint.getSignature().getName()); // Logs method name
        log.info("Status: {}", result.getStatusCode()); // Logs HTTP status code
        log.info("Result: {}", result.getBody()); // Logs response body
    }
}

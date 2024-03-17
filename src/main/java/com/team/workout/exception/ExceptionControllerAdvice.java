package com.team.workout.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler({RuntimeException.class, IllegalArgumentException.class})
    public ResponseEntity<String> nonExpectedExceptionHandler(RuntimeException exception) {
        String exceptionMessage = exception.getMessage();
        log.info("non expected exception message : {}", exceptionMessage, exception);
        return ResponseEntity.badRequest().body(exceptionMessage);
    }


}
package com.biel.silva.uolhostbackend.exception;

import com.biel.silva.uolhostbackend.dto.ExceptionDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
@RestControllerAdvice
public class ControllerExceptionHandler {


    private static final String NO_CODENAME_AVAILABLE = "NO CODENAME AVAILABLE FOR THIS GROUP";
    private static final String AVAILABLE_GROUPER = "CHOOSE A AVAILABLE GROUPER, AVENGERS,JUSTICE_LEAGUE,FANTASTIC_FOUR,TEEN_TITANS OR X_MEN";
    private static final String NAME_FIELD = "PLEASE FILL IN THE NAME FIELD";
    private static final String EMAIL_FIELD = "PLEASE FILL IN THE EMAIL FIELD";
    private static final String EMAIL_NOT_VALID = "ENTER A VALID EMAIL";

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity handleNoSuchElementException(NoSuchElementException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(NO_CODENAME_AVAILABLE, HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.badRequest().body(exceptionDTO);

    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(AVAILABLE_GROUPER, HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
    @ExceptionHandler(EmptyNameFieldException.class)
    public ResponseEntity handleEmptyNameField(EmptyNameFieldException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(NAME_FIELD, HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
    @ExceptionHandler(EmptyEmailFieldException.class)
    public ResponseEntity handleEmptyEmailFieldException(EmptyEmailFieldException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(EMAIL_FIELD, HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleEmailNotValid(ConstraintViolationException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(EMAIL_NOT_VALID, HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.badRequest().body(exceptionDTO);
    }


}


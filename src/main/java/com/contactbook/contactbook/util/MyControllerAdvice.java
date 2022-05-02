package com.contactbook.contactbook.util;

import com.contactbook.contactbook.entity.EmailIdAlreadyPresent;
import com.contactbook.contactbook.entity.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.NoSuchElementException;
import javax.validation.ConstraintViolationException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class MyControllerAdvice  {
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> UserNotFound(UserNotFound userContactNotFound) {
        return new ResponseEntity<>(Constants.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>(Constants.MOB_NOT_PRESENT, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailIdAlreadyPresent.class)
    public ResponseEntity<String> handleEmailIdExist(EmailIdAlreadyPresent emailIdAlreadyPresent) {
        return new ResponseEntity<>(Constants.EMAIL_ID_ALREADY_EXIST, HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}



package com.builtech.gst.config;

import com.builtech.gst.dto.ErrorResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<?> InvalidParameters(InvalidParameterException e){
        ErrorResponse error = new ErrorResponse(e.getMessage(),"Parametres incorrects !", LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<?> ArrayIndexOut(ArrayIndexOutOfBoundsException e){
        ErrorResponse error = new ErrorResponse(e.getMessage(),"Liste mal passée !", LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> EntityNotFound(EntityNotFoundException e){
        ErrorResponse error = new ErrorResponse(e.getMessage(),"Informations absentes !", LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<?> EntityExists(EntityExistsException e){
        ErrorResponse error = new ErrorResponse(e.getMessage(),"Des informations deja utilisées !", LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

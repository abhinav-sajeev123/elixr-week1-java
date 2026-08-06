package com.example.practice.exception;
import com.example.practice.response.GenericResponse;
import com.example.practice.response.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(StudentNotFoundException.class)
        public ResponseEntity<GenericResponse>handleStudentNotFound(StudentNotFoundException ex){
        GenericResponse genericResponse=new GenericResponse(Status.FAILURE,
                ex.getMessage(),
                null,
                null,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(genericResponse);
        }


        @ExceptionHandler(MissingServletRequestParameterException.class)
        public ResponseEntity<GenericResponse>handleMissingParameter(MissingServletRequestParameterException ex){
                GenericResponse genericResponse=new GenericResponse(Status.FAILURE,
                        "parameter is required to fill",
                       null,
                       null,
                        LocalDateTime.now()
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
        }

        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public ResponseEntity<GenericResponse>handleTypeMismatch(MethodArgumentTypeMismatchException ex){
                GenericResponse genericResponse =new GenericResponse(Status.FAILURE,
                        "Parameter should be a number",
                        null,
                        null,
                        LocalDateTime.now()
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
        }

        @ExceptionHandler(ValidationException.class)
        public ResponseEntity<GenericResponse>handleValidationError(ValidationException ex){
                GenericResponse genericResponse=new GenericResponse(Status.FAILURE,
                        null,
                        ex.getErrors(),
                        null,
                        LocalDateTime.now()
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
        }

        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<GenericResponse>handleJsonFormatAndMismatchType(HttpMessageNotReadableException ex){
                GenericResponse genericResponse=new GenericResponse(Status.FAILURE,
                        "Invalid json format or datatype mismatch",
                        null,
                        null,
                        LocalDateTime.now()
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
        }
}

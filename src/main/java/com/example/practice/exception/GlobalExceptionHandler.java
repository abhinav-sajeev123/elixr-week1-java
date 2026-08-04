package com.example.practice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.practice.response.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(StudentNotFoundException.class)
        public ResponseEntity<ErrorResponse>handleStudentNotFound(StudentNotFoundException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse>handleValidation(MethodArgumentNotValidException ex){
        String message=ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        ErrorResponse errorResponse=new ErrorResponse(message,
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        @ExceptionHandler(MissingServletRequestParameterException.class)
        public ResponseEntity<ErrorResponse>handleMissingParameter(MissingServletRequestParameterException ex){
                ErrorResponse errorResponse=new ErrorResponse(ex.getParameterName()+" : Parameter is required to fill",
                       HttpStatus.BAD_REQUEST.value(),
                        LocalDateTime.now()
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
}

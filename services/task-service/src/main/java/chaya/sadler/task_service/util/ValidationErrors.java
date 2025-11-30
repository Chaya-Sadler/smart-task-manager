package chaya.sadler.task_service.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationErrors {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException methodArgumentNotValidException) {
       List<String> validateErrors =  methodArgumentNotValidException.getBindingResult()
                .getFieldErrors()
                .stream()
                .map( e -> e.getField() + " : " + e.getDefaultMessage())
                .toList();

        Map<String, Object> errors = new HashMap<>();
        errors.put("errors", validateErrors);
        errors.put("timestamp", LocalDateTime.now());
        errors.put("status", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }
}

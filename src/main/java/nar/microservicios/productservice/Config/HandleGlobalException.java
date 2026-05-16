package nar.microservicios.productservice.Config;

import jakarta.servlet.http.HttpServletRequest;
import nar.microservicios.productservice.Config.Custom.ProductNotFoundException;
import nar.microservicios.productservice.Config.DTos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleGlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationErrors(MethodArgumentNotValidException exce){
        Map<String,String> errors = new HashMap<>();
        exce.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> productNotFound(ProductNotFoundException exception,
                                                              HttpServletRequest request){
        ErrorResponse errorDto = ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalTime.now().toString())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

}

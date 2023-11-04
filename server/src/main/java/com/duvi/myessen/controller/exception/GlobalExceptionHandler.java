package com.duvi.myessen.controller.exception;


import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import com.duvi.myessen.controller.exception.food.FoodNotFoundException;
import com.duvi.myessen.controller.exception.user.UserNotFoundException;
import com.duvi.myessen.domain.exception.ApiError;

import io.micrometer.common.lang.Nullable;


//GlobalException > ExceptionHandler (delegating exceptions) > SpecificExpHandler (create body of the response) > InternalHandler (send the response)
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public final ResponseEntity<ApiError> exceptionHandler(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof FoodNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            FoodNotFoundException fnfe = (FoodNotFoundException) ex;
            return fnfeHandler(fnfe, headers, status, request);
        } else if (ex instanceof UserNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            UserNotFoundException unfe = (UserNotFoundException) ex;
            return unfeHandler(unfe, headers, status, request);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return internalExceptionHandler(ex, null, headers, status, request);
        }
    }

    public final ResponseEntity<ApiError> fnfeHandler(FoodNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ObjectError errors = new ObjectError("Food Not Found Exception", ex.getMessage());
        ApiError body = new ApiError(Collections.singletonList(errors));
        return internalExceptionHandler(ex, body, headers, status, request);
    }

    public final ResponseEntity<ApiError> unfeHandler(UserNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ObjectError errors = new ObjectError("User Not Found Exception", ex.getMessage());
        ApiError body = new ApiError(Collections.singletonList(errors));
        return internalExceptionHandler(ex, body, headers, status, request);
    }

    public final ResponseEntity<ApiError> internalExceptionHandler(Exception ex, @Nullable ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (status.equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }
}

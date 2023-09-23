package com.duvi.myessen.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FoodAlreadyExistsExceptionAdvide {
    @ResponseBody
    @ExceptionHandler(FoodAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FOUND)
    String foodAlreadyExistsHandler(FoodAlreadyExistsException ex) {
        return ex.getMessage();
    }
}

//*package com.duvi.myessen.core.exceptions;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;

// @ControllerAdvice
// public class FoodNotFoundExceptionAdvice {


//     @ResponseBody
//     @ExceptionHandler(FoodNotFoundException.class)
//     @ResponseStatus(HttpStatus.NOT_FOUND)
//     String foodNotFoundHandler(FoodNotFoundException ex ) {
//         return ex.getMessage();
//     }
// }
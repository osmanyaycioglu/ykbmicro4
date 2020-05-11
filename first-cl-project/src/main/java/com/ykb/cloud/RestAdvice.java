package com.ykb.cloud;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> errorHandle(final Exception exp) {
        if (exp instanceof IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(new ErrorObj(exp.getMessage(),
                                                    "IT",
                                                    10045));
        } else if (exp instanceof IllegalStateException) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                                 .body(new ErrorObj(exp.getMessage(),
                                                    "IT",
                                                    10045));
        } else if (exp instanceof MethodArgumentNotValidException) {
            ErrorObj eo = new ErrorObj("Validation error",
                                       "IT",
                                       10045);
            MethodArgumentNotValidException m = (MethodArgumentNotValidException) exp;
            BindingResult bindingResultLoc = m.getBindingResult();
            List<ObjectError> allErrorsLoc = bindingResultLoc.getAllErrors();
            for (ObjectError objectErrorLoc : allErrorsLoc) {
                ErrorObj subErrorObjLoc = new ErrorObj(objectErrorLoc.getDefaultMessage()
                                                       + " "
                                                       + objectErrorLoc.getObjectName(),
                                                       "IT",
                                                       10045);
                eo.addSubError(subErrorObjLoc);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(eo);
        } else {
            return ResponseEntity.status(580)
                                 .body(new ErrorObj(exp.getMessage(),
                                                    "IT",
                                                    10045));
        }
    }

}


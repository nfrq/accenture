package com.accenture.assessmenttest.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.accenture.assessmenttest.controllers.responses.ErrorResponse;
import com.accenture.assessmenttest.exceptions.NotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler extends RuntimeException {
    
    @ExceptionHandler(value = NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleNotFound(NotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(
            e.getStatus(), 
            e.getCode(), 
            e.getMessage()
        );

        return errorResponse;
    }

}

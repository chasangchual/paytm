package com.sangchual.paytm.softwarechallenges.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionProcessor {
    /********************************************************
     * HTTP Status Code  - Bad Request (400)
     *******************************************************/
    @ExceptionHandler(InvalidDataFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Error handleBadRequest(InvalidDataFormatException ex)
    {
        return ex.getError();
    }

    @ExceptionHandler(InvalidUserRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Error handleBadRequest(InvalidUserRequestException ex)
    {
        return ex.getError();
    }


    /********************************************************
     * HTTP Status Code  - Not Found (404)
     *******************************************************/
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    Error handleNotFound(ResourceNotFoundException ex)
    {
        return ex.getError();
    }

    /********************************************************
     * HTTP Status Code  - Resource Conflict (409)
     *******************************************************/
    @ExceptionHandler(ResourceConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    Error handleResourceConflict(ResourceConflictException ex)
    {
        return ex.getError();
    }

    /********************************************************
     * HTTP Status Code  - Internal Server Error (500)
     *******************************************************/
    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    Error handleInternalServer(InternalServerException ex)
    {
        return ex.getError();
    }
}

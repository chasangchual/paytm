package com.sangchual.paytm.softwarechallenges.exception;

public class ResourceNotFoundException extends ExceptionBase {
    static Integer CODE = ExceptionType.RESOURCE_NOT_FOUND.getValue() ;
    public ResourceNotFoundException(String message) {
        super(CODE, message);
    }
}

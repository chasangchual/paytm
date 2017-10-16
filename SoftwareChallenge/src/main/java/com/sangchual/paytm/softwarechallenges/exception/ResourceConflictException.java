package com.sangchual.paytm.softwarechallenges.exception;

public class ResourceConflictException extends ExceptionBase {
    static Integer CODE = ExceptionType.DUPLICATED_RESOURCE.getValue() ;

    public ResourceConflictException(String message) {
        super(CODE, message);
    }
}

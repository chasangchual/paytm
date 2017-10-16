package com.sangchual.paytm.softwarechallenges.exception;

public class InvalidUserRequestException extends ExceptionBase {
    static Integer CODE = ExceptionType.BAD_REQUEST.getValue() ;
    public InvalidUserRequestException(String message) {
        super(CODE, message);
    }
}

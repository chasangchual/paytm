package com.sangchual.paytm.softwarechallenges.exception;

public class InternalServerException extends ExceptionBase {
    static Integer CODE = ExceptionType.INTERNAL_SERVER_ERROR.getValue() ;

    public InternalServerException(String message) {
        super(CODE, message);
    }
}

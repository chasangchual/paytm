package com.sangchual.paytm.softwarechallenges.exception;

public class InvalidDataFormatException extends ExceptionBase {
    static Integer CODE = ExceptionType.BAD_REQUEST.getValue() ;

    public InvalidDataFormatException(String message) {
        super(CODE, message);
    }
}

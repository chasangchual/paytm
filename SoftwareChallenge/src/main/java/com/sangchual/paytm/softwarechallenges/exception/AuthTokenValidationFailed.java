package com.sangchual.paytm.softwarechallenges.exception;

public class AuthTokenValidationFailed extends ExceptionBase {
    static Integer CODE = ExceptionType.AUTH_TOKEN_VALIDATION_FAILURE.getValue() ;

    public AuthTokenValidationFailed(String message) {
        super(CODE, message);
    }
}


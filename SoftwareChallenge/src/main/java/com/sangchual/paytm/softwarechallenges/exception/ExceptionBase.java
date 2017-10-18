package com.sangchual.paytm.softwarechallenges.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

public class ExceptionBase extends RuntimeException {
    @Getter
    final Error error ;

    public ExceptionBase(@NonNull Integer code, @NonNull String message) {
        super(message);
        this.error = new Error(code, message) ;
    }
}

package com.sangchual.paytm.softwarechallenges.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
public class Error {
    @Getter
    @Setter
    Integer code ;

    @Getter
    @Setter
    String message ;

    public Error(@NonNull Integer code, @NonNull String message) {
        this.code = code ;
        this.message = message ;
    }
}

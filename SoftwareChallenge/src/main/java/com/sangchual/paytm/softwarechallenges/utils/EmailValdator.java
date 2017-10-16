package com.sangchual.paytm.softwarechallenges.utils;

import org.springframework.stereotype.Component;

@Component
public class EmailValdator {
    String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    public Boolean isValid(String email) {
        return Boolean.valueOf(email.matches(EMAIL_REGEX)) ;
    }
}

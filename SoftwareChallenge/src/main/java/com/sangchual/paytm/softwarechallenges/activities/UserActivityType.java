package com.sangchual.paytm.softwarechallenges.activities;

import lombok.Getter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public enum UserActivityType {
    SIGN_UP("signup"),
    SIGN_IN("signin"),
    UPDATE_PASSWORD("update_password"),
    SEARCH("search") ;

    @Getter
    final String value ;

    UserActivityType(String value) {
        this.value = value ;
    }
}

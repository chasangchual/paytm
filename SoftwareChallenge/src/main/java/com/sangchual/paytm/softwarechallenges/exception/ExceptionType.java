package com.sangchual.paytm.softwarechallenges.exception;

import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;

public enum ExceptionType {
    RESOURCE_NOT_FOUND(100001),
    DUPLICATED_RESOURCE(100002),
    DB_ERROR(100003),
    INTERNAL_SERVER_ERROR(100004),
    BAD_REQUEST(100005),
    AUTH_TOKEN_VALIDATION_FAILURE(100006),;

    @Getter
    private final Integer value ;

    private ExceptionType(Integer value) {
        this.value = value ;
    }
}

package com.sangchual.paytm.softwarechallenges.user;

import lombok.Getter;
import lombok.Setter;

public class Result {
    public static final Integer SUCCESS = 0 ;

    @Getter
    @Setter
    Integer code ;

    @Getter
    @Setter
    String message ;

    @Getter
    @Setter
    String authToken ;

}

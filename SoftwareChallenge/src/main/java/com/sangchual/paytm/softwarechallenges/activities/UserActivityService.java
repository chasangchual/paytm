package com.sangchual.paytm.softwarechallenges.activities;

import java.util.List;

public interface UserActivityService {
    public UserActivity save(UserActivity userActivity) ;
    public Iterable<UserActivity> findAll() ;
    public List<UserActivity> findByEmail(String email)  ;
}

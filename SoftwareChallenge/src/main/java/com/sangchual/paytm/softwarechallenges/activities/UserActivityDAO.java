package com.sangchual.paytm.softwarechallenges.activities;

import com.sangchual.paytm.softwarechallenges.user.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserActivityDAO implements UserActivityService {
    AtomicLong seq = new AtomicLong() ;

    @Autowired
    private UserActivityRepository userActivityRepository ;

    public UserActivity save(UserActivity userActivity) {
        userActivity.setId(generateId(userActivity)) ;
        userActivity.setTimestamp(String.valueOf(Instant.now().toEpochMilli()));

        return userActivityRepository.save(userActivity) ;
    }

    public Iterable<UserActivity> findAll() {
        return userActivityRepository.findAll();
    }
    public List<UserActivity> findByEmail(String email)  {
        return userActivityRepository.findByEmail(email) ;
    }

    private String generateId(UserActivity userActivity) {
        if (StringUtils.isEmpty(userActivity.getId())) {
            return userActivity.getEmail() + "_" + userActivity.getTimestamp() + "_" + String.valueOf(seq.incrementAndGet());
        } else {
            return userActivity.getId();
        }
    }
}

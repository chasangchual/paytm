package com.sangchual.paytm.softwarechallenges.user.jpa;

import com.google.common.hash.Hashing;
import com.sangchual.paytm.softwarechallenges.exception.ResourceNotFoundException;
import com.sangchual.paytm.softwarechallenges.user.entity.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class UserDAO {
    @Autowired
    private UserRepository userRepository ;

    public Boolean exists(@NonNull String email) {
        User user = userRepository.findOne(email) ;
        if(user != null) {
            return Boolean.TRUE ;
        }

        return Boolean.FALSE ;
    }

    public Boolean find(@NonNull String email, @NonNull String password) {
        User user = userRepository.findOne(email) ;
        if(user != null) {
            if(user.getPassword().equals(getHashedPassword(password))) {
                return Boolean.TRUE ;
            }
        }

        return Boolean.FALSE ;
    }

    public void append(@NonNull String username, @NonNull String email, @NonNull String password) {
        userRepository.save(new User(username, email, getHashedPassword(password))) ;
    }

    public Boolean updatePassword(@NonNull String email, @NonNull String password) {
        if(exists(email)) {
            User user = userRepository.findOne(email) ;
            user.setPassword(getHashedPassword(password));
            userRepository.save(user) ;
            return Boolean.TRUE ;
        } else {
            return Boolean.FALSE ;
        }
    }

    private String getHashedPassword(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }
}

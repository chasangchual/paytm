package com.sangchual.paytm.softwarechallenges.user.jpa;

import com.sangchual.paytm.softwarechallenges.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String>{
}

package com.sangchual.paytm.softwarechallenges.activities;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserActivityRepository extends ElasticsearchRepository<UserActivity, String> {
    List<UserActivity> findByEmail(String email) ;
}

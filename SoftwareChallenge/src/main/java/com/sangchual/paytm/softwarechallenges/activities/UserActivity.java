package com.sangchual.paytm.softwarechallenges.activities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "paytm_weather", type = "user_activites")
@Getter
@Setter
@NoArgsConstructor
public class UserActivity {
    @Id
    private String Id = "";
    private String email = "";
    private String activity = "";
    private String params = "";
    private String timestamp = "";

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", Id).append("email", email).append("activity", activity)
                .append("timestamp", timestamp).toString();
    }

    public UserActivity withEmail(String email) {
        this.email = email ;
        return this ;
    }

    public UserActivity withActivity(String activity) {
        this.activity = activity ;
        return this ;
    }

    public UserActivity withParams(String params) {
        this.params = params ;
        return this ;
    }
}

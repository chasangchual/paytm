package com.sangchual.paytm.softwarechallenges.user.entity;

import com.sun.javafx.beans.IDProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @Column(name="email")
    @Getter
    @Setter
    private String email ;

    @Column(name="username")
    @Getter
    @Setter
    private String username ;

    @Column(name="password")
    @Getter
    @Setter
    private String password ;

    protected User() {

    }

    public User(String  username, String email, String password) {
        this.username = username ;
        this.email = email ;
        this.password = password ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("user name", username)
                .append("email", email).toString();
    }
}

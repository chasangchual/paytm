package com.sangchual.paytm.softwarechallenges.user.entity;

import com.sun.javafx.beans.IDProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @Column(name="email")
    private String email ;

    @Column(name="username")
    private String username ;

    @Column(name="password")
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

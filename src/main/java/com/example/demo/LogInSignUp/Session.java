package com.example.demo.LogInSignUp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "session_token")
    private String token;

    @Column(name = "expires_at")
    private Timestamp expires_at;

    Session() {

    }

    public Session(Integer id, Integer user_id, String token, Timestamp expires_at) {
        this.id = id;
        this.user_id = user_id;
        this.token = token;
        this.expires_at = expires_at;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getToken() {
        return token;
    }

    public Timestamp getExpires_at() {
        return expires_at;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setExpires_at(Timestamp expires_at) {
        this.expires_at = expires_at;
    }
}


package com.example.demo.LogInSignUp;

public class UserLogin {
    private String email;
    private String password;

    // Геттеры и сеттеры

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Конструкторы

    UserLogin() {

    }

    UserLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
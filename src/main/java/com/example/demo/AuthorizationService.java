package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.regex.Pattern;

@SpringBootApplication
public class AuthorizationService {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationService.class, args);
    }
}
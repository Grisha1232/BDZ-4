package com.example.demo.LogInSignUp;

import java.util.List;

public interface SessionService {
    void create(Session session);
    List<Session> readAll();
    Session read(int id);
    boolean delete(int id);
}

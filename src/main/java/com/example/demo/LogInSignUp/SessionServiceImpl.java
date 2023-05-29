package com.example.demo.LogInSignUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public void create(Session session) {
        sessionRepository.save(session);
    }

    @Override
    public List<Session> readAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session read(int id) {
        return sessionRepository.getReferenceById(id);
    }

    @Override
    public boolean delete(int id) {
        if (sessionRepository.existsById(id)) {
            sessionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.example.demo.Orders;

import java.util.List;

public interface Service<T> {
    void create(T serv);

    List<T> readAll();

    T read(int id);

    boolean update(T serv, int id);

    boolean delete(int id);
}

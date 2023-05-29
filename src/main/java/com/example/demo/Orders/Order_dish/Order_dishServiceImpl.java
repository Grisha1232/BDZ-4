package com.example.demo.Orders.Order_dish;

import com.example.demo.Orders.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class Order_dishServiceImpl implements Service<Order_dish> {

    @Autowired
    private Order_dishRepository order_dishRepository;

    @Override
    public void create(Order_dish serv) {
        order_dishRepository.save(serv);
    }

    @Override
    public List<Order_dish> readAll() {
        return order_dishRepository.findAll();
    }

    @Override
    public Order_dish read(int id) {
        return order_dishRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Order_dish serv, int id) {
        if (order_dishRepository.existsById(id)) {
            order_dishRepository.save(serv);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (order_dishRepository.existsById(id)) {
            order_dishRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.example.demo.Orders.Order;

import com.example.demo.Orders.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class OrderServiceImpl implements Service<Order> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void create(Order serv) {
        orderRepository.save(serv);
    }

    @Override
    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order read(int id) {
        return orderRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Order serv, int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.save(serv);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

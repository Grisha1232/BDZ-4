package com.example.demo.Orders.Dish;

import com.example.demo.Orders.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class DishServiceImpl implements Service<Dish> {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public void create(Dish serv) {
        dishRepository.save(serv);
    }

    @Override
    public List<Dish> readAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish read(int id) {
        return dishRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Dish serv, int id) {
        if (dishRepository.existsById(id)) {
            dishRepository.save(serv);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (dishRepository.existsById(id)) {
            dishRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.example.demo.Orders;

import com.example.demo.Orders.Dish.Dish;

import java.util.List;

public class OrderRequest {
    private Integer id;
    private List<Dish> order;
    private Integer countDishes;
    private String specialRequests;
    private String status;

    public Integer getId() {
        return id;
    }

    public List<Dish> getOrder() {
        return order;
    }

    public Integer getCountDishes() {
        return countDishes;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder(List<Dish> order) {
        this.order = order;
    }

    public void setCountDishes(Integer countDishes) {
        this.countDishes = countDishes;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

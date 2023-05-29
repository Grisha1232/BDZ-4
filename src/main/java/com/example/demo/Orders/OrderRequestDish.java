package com.example.demo.Orders;

public class OrderRequestDish {
    private Integer id;
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

package com.example.demo.Orders.Order_dish;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "order_dish")
public class Order_dish {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "dish_id")
    private Integer dish_id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;


    public Order_dish() {

    }

    public Order_dish(Integer id, Integer order_id, Integer dish_id, Integer quantity, Double price) {
        this.id = id;
        this.dish_id = dish_id;
        this.order_id = order_id;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDish_id() {
        return dish_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDish_id(Integer dish_id) {
        this.dish_id = dish_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
}

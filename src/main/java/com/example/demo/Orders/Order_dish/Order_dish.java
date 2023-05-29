package com.example.demo.Orders.Order_dish;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.text.DecimalFormat;

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
    private DecimalFormat price;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "update_at")
    private Timestamp updated_at;

    public Order_dish() {

    }

    public Order_dish(Integer id, Integer order_id, Integer dish_id, Integer quantity, DecimalFormat price, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.dish_id = dish_id;
        this.order_id = order_id;
        this.quantity = quantity;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public DecimalFormat getPrice() {
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

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(DecimalFormat price) {
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

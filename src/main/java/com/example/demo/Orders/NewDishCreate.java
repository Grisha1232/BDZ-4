package com.example.demo.Orders;

import java.sql.Timestamp;
import java.text.DecimalFormat;

public class NewDishCreate {
    private Integer user_id;
    private Integer dish_id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private Boolean is_available;
    private Timestamp created_at = null;
    private Timestamp updated_at = null;

    public Double getPrice() {
        return price;
    }

    public Integer getDish_id() {
        return dish_id;
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

    public Integer getUser_id() {
        return user_id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIs_available() {
        return is_available;
    }

    public String getName() {
        return name;
    }

    public void setDish_id(Integer dish_id) {
        this.dish_id = dish_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIs_available(Boolean is_available) {
        this.is_available = is_available;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NewDishCreate() {

    }

    public NewDishCreate(Integer user_id, Integer dish_id, String name, String description, Double price, Integer quantity, Boolean is_available, Timestamp created_at, Timestamp updated_at) {
        this.user_id = user_id;
        this.dish_id = dish_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.is_available = is_available;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}

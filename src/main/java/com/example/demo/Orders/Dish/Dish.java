package com.example.demo.Orders.Dish;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.text.DecimalFormat;

@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private DecimalFormat price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_available")
    private Boolean is_available;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    public Dish() {

    }

    public Dish(Integer id, String name, String description, DecimalFormat price, Integer quantity, Boolean is_available, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.is_available = is_available;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Boolean getIs_available() {
        return is_available;
    }

    public DecimalFormat getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setIs_available(Boolean is_available) {
        this.is_available = is_available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(DecimalFormat price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

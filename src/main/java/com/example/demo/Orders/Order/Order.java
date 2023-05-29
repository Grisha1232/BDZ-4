package com.example.demo.Orders.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.aspectj.weaver.ast.Or;

import java.sql.Timestamp;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "status")
    private String status;

    @Column(name = "special_requests")
    private String special_requests;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    public Order(){

    }
    public Order(Integer id, Integer user_id, String status, String special_requests, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.created_at = created_at;
        this.special_requests = special_requests;
        this.status = status;
        this.updated_at = updated_at;
        this.user_id = user_id;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecial_requests() {
        return special_requests;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setSpecial_requests(String special_requests) {
        this.special_requests = special_requests;
    }
}

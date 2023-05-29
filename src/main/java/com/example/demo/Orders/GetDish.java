package com.example.demo.Orders;

public class GetDish {
    private Integer user_id;
    private Integer dish_id;

    public Integer getDish_id() {
        return dish_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setDish_id(Integer dish_id) {
        this.dish_id = dish_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}

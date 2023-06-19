package com.example.springboot.Exsercise5.models;

import org.springframework.stereotype.Component;

@Component
public class RestaurantConfig {
    private double minPrice;
    private double discountPrice;

    public RestaurantConfig() {
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}

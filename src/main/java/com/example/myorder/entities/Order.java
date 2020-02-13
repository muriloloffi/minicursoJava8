package com.example.myorder.entities;

import com.example.myorder.enums.OrderStatusEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "USER_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TOTAL_VALUE", nullable = false)
    private BigDecimal totalValue;

    @Column(name = "STATUS", nullable = false)
    private OrderStatusEnum status; //KKK

    @ManyToOne
    @JoinColumn(name = "RESTAURANTE", nullable = false)
    private Restaurant restaurant;

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public Order setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public Order setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "USER", nullable = false)
    private User user;
}

package com.example.myorder.entities;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANTE")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column (name = "EMAIL", nullable = false)
    private String email;


    public Integer getId() {
        return id;
    }

    public Restaurant setId(Integer id) {
        this.id = id;
        return this;
    }
}

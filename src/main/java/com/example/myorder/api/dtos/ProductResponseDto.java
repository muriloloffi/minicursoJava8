package com.example.myorder.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("Objeto de resposta criação de produto")
public class ProductResponseDto {
    @ApiModelProperty(value = "${product.create.name}")
    private String name;

    @ApiModelProperty(value = "${product.create.value}")
    private BigDecimal value;

    @ApiModelProperty(value = "${product.response.restaurant}")
    private RestaurantResponseDto restaurant;

    public String getName() {
        return name;
    }

    public ProductResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public ProductResponseDto setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public RestaurantResponseDto getRestaurant() {
        return restaurant;
    }

    public ProductResponseDto setRestaurant(RestaurantResponseDto restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}

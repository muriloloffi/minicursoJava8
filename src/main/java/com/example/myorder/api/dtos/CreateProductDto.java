package com.example.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateProductDto {

    @NotEmpty
    @ApiModelProperty(value = "${product.create.name}")
    private String name;

    @NotNull
    @Min(value = 1, message = "Valor minimo deve ser 1")
    @ApiModelProperty(value = "${product.create.value}")
    private BigDecimal value;

    @NotNull
    @ApiModelProperty(value = "${product.create.restaurantId}")
    private Integer restaurantId;

    public String getName() {
        return name;
    }

    public CreateProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public CreateProductDto setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public CreateProductDto setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }
}

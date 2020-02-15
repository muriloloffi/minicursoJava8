package com.example.myorder.api.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderItemDto {

    @NotNull
    @ApiModelProperty(value = "${orderItem.create.product}")
    private Integer productId;

    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "${orderItem.create.quantity}")
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public OrderItemDto setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}

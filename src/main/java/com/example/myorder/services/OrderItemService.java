package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateOrderDto;
import com.example.myorder.api.dtos.OrderItemDto;
import com.example.myorder.entities.Order;
import com.example.myorder.entities.OrderItem;
import com.example.myorder.entities.Product;
import com.example.myorder.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    private ProductService productService; //eh chuncho q chama neh

    public List<OrderItem> createOrderItems(List<OrderItemDto> items, Order order){
        return items.stream()
                .map(orderItemDto -> buildOrderItem(orderItemDto, order))
                .collect(Collectors.toList());
    }

    public List<OrderItem> createOrderItens(List<CreateOrderDto>)

    private OrderItem buildOrderItem(OrderItemDto orderItemDto, Order order) {
        return new OrderItem()
                .setProduct(productService.findById(orderItemDto.getProductId()))
                .setOrder(order)
                .setQuantity(orderItemDto.getQuantity());
    }

    private List<Product> find(List<Integer> productsId ) {

    }
}

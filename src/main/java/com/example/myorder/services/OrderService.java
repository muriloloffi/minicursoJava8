package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateOrderDto;
import com.example.myorder.api.dtos.OrderItemDto;
import com.example.myorder.api.dtos.OrderResponseDto;
import com.example.myorder.entities.Order;
import com.example.myorder.entities.Product;
import com.example.myorder.enums.OrderStatusEnum;
import com.example.myorder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    public OrderResponseDto create(CreateOrderDto createOrderDto){
        Order order = createOrder(createOrderDto);

        return new OrderResponseDto()
                .setId(order.getId())
                .setId
    };

    private Order createOrder(CreateOrderDto createOrderDto) {
        Order order = new Order();

        return new Order()
                .setStatus(OrderStatusEnum.OPEN)
                .setRestaurant(restaurantService.findById(createOrderDto.getRestaurantId()))
                .setUser(userService.findById(createOrderDto.getUserId()))
                .setItems(orderItemService.createOrderItems(createOrderDto.getOrderItems(), order))
                .setTotalValue(calculateOrderTotalValue(createOrderDto.getOrderItems()));
    }

    private BigDecimal calculateOrderTotalValue(List<OrderItemDto> items){
        return items.stream().map(orderItemDto -> {
            Product referenceProduct = productService.findById(orderItemDto.getProductId());

            Double itemValue = new BigDecimal (referenceProduct.getValue().multiply(BigDecimal.valueOf(orderItemDto.getQuantity())));

                    return itemValue;
        }).reduce(0d, Double::sum);

    }


}

package com.example.myorder.services;


import com.example.myorder.api.dtos.CreateProductDto;
import com.example.myorder.api.dtos.ProductResponseDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.entities.Product;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.exception.NotFoundException;
import com.example.myorder.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestaurantService restaurantService;

    public ProductResponseDto create(CreateProductDto createProductDto) {

        Restaurant restaurant = restaurantService.findById(createProductDto.getRestaurantId());

        Product product = new Product()
                .setName(createProductDto.getName())
                .setValue(createProductDto.getValue())
                .setRestaurant(restaurant);

        product = productRepository.save(product);

        RestaurantResponseDto restaurantResponseDto = new RestaurantResponseDto()
                .setName(product.getRestaurant().getName())
                .setEmail(product.getRestaurant().getEmail())
                .setPhone(product.getRestaurant().getPhone())
                .setId(product.getRestaurant().getId());

        return new ProductResponseDto()
                .setName(product.getName())
                .setValue(product.getValue())
                .setRestaurant(restaurantResponseDto);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException
                        ("Produto não encontrado para o id " + id));
    }

    public List<Product> listById(List Integer ids)
}

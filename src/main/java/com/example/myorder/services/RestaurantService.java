package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateRestaurantDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void createRestaurant(CreateRestaurantDto createRestaurantDto) {
        //TODO Validações

        Restaurant restaurant = new Restaurant()
                .setEmail(createRestaurantDto.getEmail())
                .setName(createRestaurantDto.getName())
                .setPhone(createRestaurantDto.getPhone());

        restaurantRepository.save(restaurant); //salvando restaurante

    }

    public RestaurantResponseDto getById(Integer id){
        Optional<Restaurant> optional = restaurantRepository.findById(id);
        Restaurant restaurant = optional.get();
        return new RestaurantResponseDto()
                .setId(restaurant.getId())
                .setEmail(restaurant.getEmail())
                .setName(restaurant.getName())
                .setPhone(restaurant.getPhone());


    }
}

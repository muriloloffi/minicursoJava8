package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateUserDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.api.dtos.UserResponseDto;
import com.example.myorder.api.mappers.UserMapper;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.entities.User;
import com.example.myorder.exception.AlreadyExistsException;
import com.example.myorder.exception.NotFoundException;
import com.example.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDto create(CreateUserDto createUserDto){
        validateUserEmail(createUserDto.getEmail());
//        saveUser(UserMapper.toEntity(createUserDto));
        User user = userRepository.save(createUser(createUserDto));
//        return null;
        return UserMapper.toResponseDto(user);
    }

    private User createUser(CreateUserDto createUserDto) {
        return new User()
                .setName(createUserDto.getName())
                .setEmail(createUserDto.getEmail())
                .setAddress(createUserDto.getAddress())
                .setPassword(createUserDto.getPassword())
                .setPhone(createUserDto.getPhone());
    }

    private void validateUserEmail(String email){
        User user = userRepository.findByEmail(email);

        if (user != null) {
           throw new AlreadyExistsException("já existe um usuário cadastrado com este email");
        }

    }

    public UserResponseDto findById(Integer id){
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()){
            throw new NotFoundException("Não existe usuário para o id" + id);
        }

        return UserMapper.toResponseDto(user.get());

//        User user = optional.get();
//        return new UserResponseDto()
//                .setId(user.getId())
//                .setEmail(user.getEmail())
//                .setName(user.getName())
//                .setPhone(user.getPhone())
//                .setAddress(user.getAddress());
//    }
//
//    private User saveUser(User user){
//        return UserRepository.save(user);
//    }
    }
}

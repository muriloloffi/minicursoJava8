package com.example.myorder.api.controllers;

import com.example.myorder.api.RestPath;
import com.example.myorder.api.dtos.CreateUserDto;
import com.example.myorder.api.dtos.UserResponseDto;
import com.example.myorder.entities.User;
import com.example.myorder.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("UserController")
@RequestMapping(RestPath.BASE_PATH + "/users")
@Api(tags = "Usuários")
public class UserController {

    @Autowired //posso fazer em várias classes, como as que tem annotation Service e Repository
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto create(
            @ApiParam(value = "Objeto que contém as informações do usuário")
            @RequestBody @Valid CreateUserDto createUserDto) {
        return userService.create(createUserDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "")
    public UserResponseDto get(@RequestParam @Param("id") Integer id) {
        return userService.getById(id);
    }
}

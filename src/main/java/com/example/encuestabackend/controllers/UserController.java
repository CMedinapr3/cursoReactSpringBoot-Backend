package com.example.encuestabackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.encuestabackend.entities.UserEntity;
import com.example.encuestabackend.models.requests.UserRegisterRequestModel;
import com.example.encuestabackend.models.responses.UserRest;
import com.example.encuestabackend.services.UserService;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping()
    public UserRest createUser(@RequestBody @Valid UserRegisterRequestModel userModel) {

        UserEntity user = userService.createUser(userModel);
        
        UserRest userRest = new UserRest();
        BeanUtils.copyProperties(user, userRest);

        return userRest;
    }
    
@GetMapping
public UserRest getUser(Authentication authentication) {
 
    UserEntity user = userService.getUser(
        authentication.getPrincipal().toString()
    );

    UserRest userRest = new UserRest();
    BeanUtils.copyProperties(user, userRest);

    return userRest;
}


}

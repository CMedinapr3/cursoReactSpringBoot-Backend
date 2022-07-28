package com.example.encuestabackend.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.encuestabackend.entities.UserEntity;
import com.example.encuestabackend.models.requests.UserRegisterRequestModel;

public interface UserService extends UserDetailsService {

    public UserDetails loadUserByUsername(String email);

    public UserEntity getUser(String email);

    public UserEntity createUser(UserRegisterRequestModel user);
}

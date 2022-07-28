package com.example.encuestabackend.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.encuestabackend.annotations.UniqueEmail;
import com.example.encuestabackend.entities.UserEntity;
import com.example.encuestabackend.repositories.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        UserEntity user = userRepository.findByEmail(value);
        if(user == null){
            return true;
        }
        return false;
    }
    
}

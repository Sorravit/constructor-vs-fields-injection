package com.sorravit.constructorvsfieldsinjection.services;

import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceWithFieldInjection {

    @Autowired
    private UserRepository userRepository;

    public User getUser(){
        return this.userRepository.findByFaith();
    }
}

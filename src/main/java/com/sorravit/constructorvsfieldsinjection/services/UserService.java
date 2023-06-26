package com.sorravit.constructorvsfieldsinjection.services;

import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(){
        return this.userRepository.findByFaith();
    }
}

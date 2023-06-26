package com.sorravit.constructorvsfieldsinjection.repository;

import com.sorravit.constructorvsfieldsinjection.model.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ThreadLocalRandom;

@Repository
public class UserRepository {
    public User findByFaith() {
        User user = new User();
        user.setId(ThreadLocalRandom.current().nextLong());
        user.setEmail("sorravit@hotgmail.com");
        return user;
    }
}

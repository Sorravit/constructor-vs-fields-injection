package com.sorravit.constructorvsfieldsinjection.services;

import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceWithFieldInjectionTest {
// Mock the Bean and use autowire to inject into the service using SpringDI
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserServiceWithFieldInjection userService;

    @Test
    public void testGetUser() {
        User dummyUser = new User();
        dummyUser.setUsername("Test Faith");
        when(userRepository.findByFaith()).thenReturn(dummyUser);

        User result = userService.getUser();
        assertEquals(dummyUser, result);
    }
}
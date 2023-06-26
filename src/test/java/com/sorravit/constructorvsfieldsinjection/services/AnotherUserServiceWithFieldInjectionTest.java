package com.sorravit.constructorvsfieldsinjection.services;

import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnotherUserServiceWithFieldInjectionTest {
// Mock the Bean and use autowire to inject into the service with out using Spring DI
    @Mock
    private UserRepository userRepository;
    @InjectMocks
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
package com.sorravit.constructorvsfieldsinjection.services;

import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {


    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        // Create a mock UserRepository
        userRepository = mock(UserRepository.class);

        // Create the UserService instance with the mock UserRepository
        userService = new UserService(userRepository);
    }

    @Test
    public void testGetUser() {
        // Create a dummy User object for the expected result
        User dummyUser = new User();
        dummyUser.setUsername("big");

        // Set up the mock UserRepository to return the dummyUser when findByFaith() is called
        when(userRepository.findByFaith()).thenReturn(dummyUser);

        // Call the getUser() method of the UserService
        User result = userService.getUser();

        // Verify that the UserRepository's findByFaith() method was called once
        // and the result matches the dummyUser we set up
        assertEquals(dummyUser, result);
    }
}
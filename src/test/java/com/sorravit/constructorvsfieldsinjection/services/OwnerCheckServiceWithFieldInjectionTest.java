package com.sorravit.constructorvsfieldsinjection.services;

import com.sorravit.constructorvsfieldsinjection.model.Book;
import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OwnerCheckServiceWithFieldInjectionTest {
// Mock the Bean and use autowire to inject into the service using SpringDI
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private OwnerCheckServiceWithFieldInjection ownerCheckServiceWithFieldInjection;

    @Test
    public void testGetUser() {
        User user = new User();
        user.setUsername("Test Faith");
        when(userRepository.findByFaith()).thenReturn(user);

        User result = ownerCheckServiceWithFieldInjection.getUser();
        assertThat(result).isEqualTo(user);
    }
    @Test
    public void testGetBookOwner(){
        User user = new User();
        user.setUsername("big");
        Book book = new Book();
        book.setTitle("The Book of life");
        when(userRepository.findByFaith()).thenReturn(user);
//      The bookRepository is not mock and actually autowire by Spring DI
        assertThat(ownerCheckServiceWithFieldInjection.getBookOwner()).isEqualTo("The Book of eli belongs to big");
    }
}
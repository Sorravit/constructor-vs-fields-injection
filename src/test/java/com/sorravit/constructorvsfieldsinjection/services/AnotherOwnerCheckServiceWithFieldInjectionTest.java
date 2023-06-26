package com.sorravit.constructorvsfieldsinjection.services;

import com.sorravit.constructorvsfieldsinjection.model.Book;
import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.repository.BookRepository;
import com.sorravit.constructorvsfieldsinjection.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnotherOwnerCheckServiceWithFieldInjectionTest {
// Mock the Bean and use autowire to inject into the service with out using Spring DI
    @Mock
    private UserRepository userRepository;

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private OwnerCheckServiceWithFieldInjection ownerCheckServiceWithFieldInjection;

    @Test
    public void testGetUser() {
        User user = new User();
        user.setUsername("Test Faith");
        when(userRepository.findByFaith()).thenReturn(user);

        User result = ownerCheckServiceWithFieldInjection.getUser();
        assertEquals(user, result);
    }
    @Test
    public void testGetBookOwner(){
        User user = new User();
        user.setUsername("big");
        Book book = new Book();
        book.setTitle("The Book of life");
        when(userRepository.findByFaith()).thenReturn(user);
        when(bookRepository.findByGod()).thenReturn(book);
        assertEquals("The Book of life belongs to big", ownerCheckServiceWithFieldInjection.getBookOwner());
    }
}
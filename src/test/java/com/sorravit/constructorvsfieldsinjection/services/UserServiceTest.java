package com.sorravit.constructorvsfieldsinjection.services;

import com.sorravit.constructorvsfieldsinjection.model.Book;
import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.repository.BookRepository;
import com.sorravit.constructorvsfieldsinjection.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {


    private UserRepository userRepository;
    private OwnerCheckService ownerCheckService;
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        // Create a mock UserRepository
        userRepository = mock(UserRepository.class);
        bookRepository = mock(BookRepository.class);

        // Create the UserService instance with the mock UserRepository
        ownerCheckService = new OwnerCheckService(userRepository, bookRepository);
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setUsername("big");
        when(userRepository.findByFaith()).thenReturn(user);
        User result = ownerCheckService.getUser();
        assertThat(result).isEqualTo(user);
    }
    @Test
    public void testGetBookOwner(){
        User user = new User();
        user.setUsername("big");
        Book book = new Book();
        book.setTitle("The Book of life");
        when(userRepository.findByFaith()).thenReturn(user);
        when(bookRepository.findByGod()).thenReturn(book);
        assertThat(ownerCheckService.getBookOwner()).isEqualTo("The Book of life belongs to big");
    }
}
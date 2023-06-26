package com.sorravit.constructorvsfieldsinjection.services;

import com.sorravit.constructorvsfieldsinjection.model.User;
import com.sorravit.constructorvsfieldsinjection.repository.BookRepository;
import com.sorravit.constructorvsfieldsinjection.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerCheckService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public OwnerCheckService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public User getUser(){
        return this.userRepository.findByFaith();
    }

    public String getBookOwner(){
        String bookName = this.bookRepository.findByGod().getTitle();
        String ownerName = this.userRepository.findByFaith().getUsername();
        return bookName + " belongs to " + ownerName;
    }
}

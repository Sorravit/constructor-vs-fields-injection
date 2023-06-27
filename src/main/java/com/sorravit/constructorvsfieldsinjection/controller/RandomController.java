package com.sorravit.constructorvsfieldsinjection.controller;

import com.sorravit.constructorvsfieldsinjection.model.Address;
import com.sorravit.constructorvsfieldsinjection.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {
    @GetMapping("address")
    Address randomAddress() {
        Address address = new Address();
        address.setAddress("Earth");
        address.setPostCode("1120");
        return address;
    }

    @GetMapping("book")
    Book getBook(){
        Book book = new Book();
        book.setTitle("this is the book");
        book.setPrice(69.112);
        return book;

    }
}

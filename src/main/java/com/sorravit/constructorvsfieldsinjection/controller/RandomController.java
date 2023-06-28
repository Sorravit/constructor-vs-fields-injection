package com.sorravit.constructorvsfieldsinjection.controller;

import com.sorravit.constructorvsfieldsinjection.model.Address;
import com.sorravit.constructorvsfieldsinjection.model.Book;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RandomController {
    @GetMapping("address")
    Address randomAddress() {
        Address address = new Address();
        address.setAddress("Earth");
        address.setPostCode("1120");
        return address;
    }

    @PostMapping("address")
    Address postAddress(@Valid @RequestBody Address address) {
        log.warn("{}",address);
        return address;
    }

    @GetMapping("book")
    Book getBook() {
        Book book = new Book();
        book.setTitle("this is the book");
        book.setPrice(69.112);
        return book;
    }

    @PostMapping("book")
    Book postBook(@RequestBody Book book) {
        log.warn(String.valueOf(book));
        return book;
    }
}
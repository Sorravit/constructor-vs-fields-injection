package com.sorravit.constructorvsfieldsinjection.repository;

import com.sorravit.constructorvsfieldsinjection.model.Book;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ThreadLocalRandom;

@Repository
public class BookRepository {
    public Book findByGod(){
        Book book = new Book();
        book.setPrice(ThreadLocalRandom.current().nextDouble());
        book.setTitle("The Book of eli");
        return book;
    }
}

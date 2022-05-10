package com.test.service.client;

import com.test.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFallBackClient implements BookClient{
    @Override
    public Book selectBook(Integer bid) {
        Book book = new Book();
        book.setDesc("补救");
        return book;
    }
}

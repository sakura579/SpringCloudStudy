package com.test.service;


import com.test.entity.Book;

public interface BookService {

    Book selectByBid(Integer bid);
}

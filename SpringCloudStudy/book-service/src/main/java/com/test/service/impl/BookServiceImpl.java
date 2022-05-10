package com.test.service.impl;

import com.test.entity.Book;
import com.test.mapper.BookMapper;
import com.test.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public Book selectByBid(Integer bid) {
        return bookMapper.getBookById(bid);
    }
}

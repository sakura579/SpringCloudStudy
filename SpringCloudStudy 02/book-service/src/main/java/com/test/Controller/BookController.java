package com.test.Controller;

import com.test.entity.Book;
import com.test.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {

    @Resource
    BookService bookService;

    @GetMapping("/selectBook/{bid}")
    public Book selectBook(@PathVariable("bid") Integer bid){
        return bookService.selectByBid(bid);
    }
}

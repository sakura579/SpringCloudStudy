package com.test.service.client;

import com.test.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "book-service",fallback = BookFallBackClient.class)
public interface BookClient {

    @RequestMapping("/selectBook/{bid}")
    public Book selectBook(@PathVariable("bid") Integer bid);
}

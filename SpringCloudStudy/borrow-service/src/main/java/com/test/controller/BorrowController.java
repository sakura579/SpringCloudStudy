package com.test.controller;

import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BorrowController {
    @Resource
    BorrowService borrowService;

    @GetMapping("/selectBorrow/{uid}")
    public UserBorrowDetail selectBorrowByUid(@PathVariable("uid") Integer uid){
       return borrowService.getUserBorrowDetailByUid(uid);
    }
}

package com.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {
    @Resource
    BorrowService borrowService;

    //@HystrixCommand(fallbackMethod = "onError")
    @GetMapping("/selectBorrow/{uid}")
    public UserBorrowDetail selectBorrowByUid(@PathVariable("uid") Integer uid){
       return borrowService.getUserBorrowDetailByUid(uid);
    }

    // 备选方案，直接返回空列表（服务降级）
    // 注意 参数和返回值和上面要一致
    UserBorrowDetail onError(Integer uid){
        System.out.println("执行备用方案");
        return new UserBorrowDetail(null, Collections.emptyList());
    }

}

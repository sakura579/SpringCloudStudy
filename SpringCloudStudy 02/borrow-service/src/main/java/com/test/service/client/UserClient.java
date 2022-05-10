package com.test.service.client;

import com.test.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-service",fallback = UserFallBackClient.class)
public interface UserClient {

    @RequestMapping("/findUserById/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid);
}

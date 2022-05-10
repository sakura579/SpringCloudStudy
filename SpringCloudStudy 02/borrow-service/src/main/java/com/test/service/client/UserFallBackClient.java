package com.test.service.client;

import com.test.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallBackClient implements UserClient{
    @Override
    public User findUserById(Integer uid) {
        User user = new User();
        user.setName("补救措施");
        return user;
    }
}

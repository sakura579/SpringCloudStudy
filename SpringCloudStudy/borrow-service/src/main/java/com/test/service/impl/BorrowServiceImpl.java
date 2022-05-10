package com.test.service.impl;

import com.test.entity.Book;
import com.test.entity.Borrow;
import com.test.entity.User;
import com.test.entity.UserBorrowDetail;
import com.test.mapper.BorrowMapper;
import com.test.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper borrowMapper;

    @Resource
    RestTemplate template;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {

        List<Borrow> borrows = borrowMapper.selectByUserId(uid);
        // 这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        // 获取User信息
        User user = template.getForObject("http://user-service/findUserById/" + uid, User.class);
        // 获取每本书的详细信息
        List<Book> bookList = borrows.stream().map(b -> {
            return template.getForObject("http://book-service/selectBook/" + b.getBid(), Book.class);
        }).collect(Collectors.toList());
        return new UserBorrowDetail(user,bookList);

        /*

        List<Borrow> borrows = borrowMapper.selectByUserId(uid);
        // RestTemplate 支持多种方式的远程调用
        RestTemplate template = new RestTemplate();
        // 这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        // 获取User信息
        User user = template.getForObject("http://localhost:8101/findUserById/" + uid, User.class);
        // 获取每本书的详细信息
        List<Book> bookList = borrows.stream().map(b -> {
            return template.getForObject("http://localhost:8201/selectBook/" + b.getBid(), Book.class);
        }).collect(Collectors.toList());
        return new UserBorrowDetail(user,bookList);
        */

    }
}

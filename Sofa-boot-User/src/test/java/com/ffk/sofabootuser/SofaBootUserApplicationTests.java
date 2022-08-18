package com.ffk.sofabootuser;

import com.example.sofabootcommon.BO.UserBO;
import com.example.sofabootcommon.entity.User;
import com.ffk.sofabootuser.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SofaBootUserApplicationTests {

    @Resource
    UserServiceImpl userService;

    @Test
    void addUser(){
        User user = new User();
        user.setPwd("123");
        user.setUsername("kk");
        System.out.println(userService.register(user));
    }

    @Test
    void updatePwd(){
        userService.updatePwd("456",1);
    }

    @Test
    void queryAllUsers(){
        System.out.println(userService.queryAllUsers());
    }

    @Test
    void queryByPage(){
        System.out.println(userService.queryByPage(1, 1));
    }

    @Test
    void deleteUser(){
        userService.deleteById(2);
    }

    @Test
    void queryAllCommentForUser(){
        UserBO userBO = userService.queryAllCommentForUser(2);
        System.out.println(userBO.getUsername());
        System.out.println(userBO.getComments());
    }
}

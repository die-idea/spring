package com.abc.service.impl;

import com.abc.dao.entity.User;
import com.abc.service.iservice.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
   @Autowired
    IUserService userService;

    @Test
    public void userExist() {
    }

    @Test
    public void login() {
        User user=new User("root","root");
        System.out.println(userService.login(user));
    }
}
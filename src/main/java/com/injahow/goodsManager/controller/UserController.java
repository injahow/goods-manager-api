package com.injahow.goodsManager.controller;

import com.injahow.goodsManager.bean.User;
import com.injahow.goodsManager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public User add(User user) { // 异步响应
        /*User user1 = new User(0,"方法",1242424,"ngfngdn");
        User user2 = userService.userRegister(user1);
        System.out.println("user2.........");
        System.out.println(user2);*/
        return null;
    }


}

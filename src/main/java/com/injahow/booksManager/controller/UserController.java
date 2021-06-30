package com.injahow.booksManager.controller;

import com.injahow.booksManager.bean.User;
import com.injahow.booksManager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/xxxxxx")
    public User getInfo(User user) { // 异步响应
        /*User user1 = new User(0,"方法",1242424,"ngfngdn");
        User user2 = userService.userRegister(user1);
        System.out.println("user2.........");
        System.out.println(user2);*/
        return null;
    }

    @PostMapping("/xxxlogin")
    @ResponseBody
    public HashMap login(User user) { // 异步响应

        /*System.out.println(user);
        System.out.println("user.........");

        HashMap hashMap = new HashMap();
        hashMap.put("code",-1);

        if(user==null){
            return hashMap;
        }
        boolean canLogin = userService.loginCheck(user);

        if(canLogin){
            hashMap.put("code",0);
            hashMap.put("username", user.getUserName());
            hashMap.put("account", user.getAccount());

        }*/

        return null;


    }

}

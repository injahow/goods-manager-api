package com.injahow.booksManager.service.impl;

import com.injahow.booksManager.bean.User;
import com.injahow.booksManager.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User userRegister(User user) {
        return null;
    }

    @Override
    public boolean loginCheck(User user) {
        return false;
    }
}

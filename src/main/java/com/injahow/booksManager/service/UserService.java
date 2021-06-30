package com.injahow.booksManager.service;

import com.injahow.booksManager.bean.User;

public interface UserService {
    User userRegister(User user);
    boolean loginCheck(User user);

}

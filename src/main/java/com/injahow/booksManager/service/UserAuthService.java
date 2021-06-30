package com.injahow.booksManager.service;

import com.injahow.booksManager.bean.User;
import com.injahow.booksManager.bean.UserAuth;

public interface UserAuthService {
    UserAuth userRegister(UserAuth userAuth);
    User loginCheck(UserAuth userAuth);
}

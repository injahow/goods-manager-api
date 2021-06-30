package com.injahow.goodsManager.service;

import com.injahow.goodsManager.bean.User;
import com.injahow.goodsManager.bean.UserAuth;

public interface UserAuthService {
    User loginCheck(UserAuth userAuth);
}

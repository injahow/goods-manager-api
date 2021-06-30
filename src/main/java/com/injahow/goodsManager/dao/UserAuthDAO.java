package com.injahow.goodsManager.dao;

import com.injahow.goodsManager.bean.UserAuth;

public interface UserAuthDAO {

    UserAuth queryUserAuthByAccount(String account);

}

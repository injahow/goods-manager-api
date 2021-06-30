package com.injahow.booksManager.dao;

import com.injahow.booksManager.bean.UserAuth;

public interface UserAuthDAO {

    UserAuth queryUserAuthByAccount(String account);

}

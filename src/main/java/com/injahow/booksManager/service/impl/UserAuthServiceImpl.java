package com.injahow.booksManager.service.impl;

import com.injahow.booksManager.bean.User;
import com.injahow.booksManager.bean.UserAuth;
import com.injahow.booksManager.dao.UserAuthDAO;
import com.injahow.booksManager.dao.UserDAO;
import com.injahow.booksManager.service.UserAuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Resource
    UserAuthDAO userAuthDAO;
    @Resource
    UserDAO userDAO;

    @Override
    public UserAuth userRegister(UserAuth userAuth) {
        return null;
    }

    @Override
    @Transactional
    public User loginCheck(UserAuth userAuthReq) {
        UserAuth userAuth;
        if(userAuthReq.getAccount()!=null){
            System.out.println("userAuthReq...................");

            userAuth = userAuthDAO.queryUserAuthByAccount(userAuthReq.getAccount());
            if(userAuth!=null){
                if(userAuth.getPassword().equals(userAuthReq.getPassword())){
                    System.out.println(userAuth.getUserId());
                    return userDAO.queryUserById(userAuth.getUserId());
                }
            }
        }

        return null;
    }

}

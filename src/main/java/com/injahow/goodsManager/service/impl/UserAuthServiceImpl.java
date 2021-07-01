package com.injahow.goodsManager.service.impl;

import com.injahow.goodsManager.bean.User;
import com.injahow.goodsManager.bean.UserAuth;
import com.injahow.goodsManager.dao.UserAuthDAO;
import com.injahow.goodsManager.dao.UserDAO;
import com.injahow.goodsManager.service.UserAuthService;
import com.injahow.goodsManager.utils.MD5Util;
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
    @Transactional
    public User loginCheck(UserAuth userAuthReq) {
        UserAuth userAuth;
        if(userAuthReq.getAccount()!=null){
            userAuth = userAuthDAO.queryUserAuthByAccount(userAuthReq.getAccount());
            if(userAuth!=null){
                if(userAuth.getPassword().equals(MD5Util.md5(userAuthReq.getPassword()))){
                    return userDAO.queryUserById(userAuth.getUserId());
                }
            }
        }
        return null;
    }

}

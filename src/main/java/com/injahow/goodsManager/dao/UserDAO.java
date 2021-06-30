package com.injahow.goodsManager.dao;

import com.injahow.goodsManager.bean.User;

import java.util.List;

public interface UserDAO {
    int insert(User User);
    User queryUserById(int id);
    User  queryUserByAccount(int account);
    User findBy(Long id);
    int deleteBy(Long id);
    int deleteById(Long id);
    int insertSelective(User record);
    List<User> listAll();
    User findById(Long id);
    int updateSelectiveBy(User record);
    int updateBy(User record);
}

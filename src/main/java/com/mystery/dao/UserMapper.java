package com.mystery.dao;

import com.mystery.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /*获取用户名*/
    String getUserName(Integer id);
    /*用户登入*/
    int getName(String name);
    /*用户注册*/
    void save(User user);

}

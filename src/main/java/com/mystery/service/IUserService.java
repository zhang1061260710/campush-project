package com.mystery.service;


import com.mystery.entity.User;

public interface IUserService {


    /*获取用户名*/
    String getUserName(Integer id);
    int getName(String name);

    /*用户注册*/
    void save(User user);
}

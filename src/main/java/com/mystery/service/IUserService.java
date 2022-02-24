package com.mystery.service;


import com.mystery.entity.User;

import java.util.List;

public interface IUserService {


    /*获取用户名*/
    String getUserName(Integer id);
    /*查看用户是否存在*/
    int getName(String name);
    /*用户注册*/
    void save(User user);
    /*查询用户个人信息*/
    User GetUserList(String name);
    /*获取所有注册用户*/
    List<User> AllUserList();

    void PersonalUpdate(User user);
}

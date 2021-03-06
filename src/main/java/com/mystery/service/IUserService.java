package com.mystery.service;


import com.mystery.entity.User;
import org.apache.ibatis.annotations.Param;

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

    //根据学号查询用户信息
    User NumberQuery(String number);

    void batchDelete(List<Integer> userIds);
    //检测注册用户名与用户学号是否存在
    int WhetherExistByNumberUsernmae( String number, String username);

    //修改密码
    void UpdatePasswordByNumber(String number,String password);
}

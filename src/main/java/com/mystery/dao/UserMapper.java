package com.mystery.dao;

import com.mystery.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /*获取用户名*/
    String getUserName(Integer id);
    /*用户登入*/
    int getName(String name);
    /*用户注册*/
    void save(User user);
    /*获取用户个人信息*/
    User GetUserList(String name);
    /*获取所有注册用户*/
    List<User> AllUserList();

    void PersonalUpdate(User user);
    //根据学号查询信息
    User NumberQuery(String number);
    //批量删除
    void  batchDelete (List<Integer> userIds);

    //检测学号和用户是否存在
    int WhetherExistByNumberUsernmae(@Param("number") String number, @Param("username") String username);
}

package com.mystery.service.impl;

import com.mystery.dao.UserMapper;
import com.mystery.entity.User;
import com.mystery.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServcieImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /*获取用户名*/
    @Override
    public String getUserName(Integer id) {
        return userMapper.getUserName(id);
    }

    @Override
    public int getName(String name) {
       return userMapper.getName(name);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public User GetUserList(String name) {
        return userMapper.GetUserList(name);
    }

    @Override
    public List<User> AllUserList() {
        return userMapper.AllUserList();
    }

    @Override
    public void PersonalUpdate(User user) {
        userMapper.PersonalUpdate(user);
    }

    @Override
    public User NumberQuery(String number) {
        return userMapper.NumberQuery(number);
    }

    @Override
    public void batchDelete(List<Integer> userIds) {

        userMapper.batchDelete(userIds);
    }

    @Override
    public int WhetherExistByNumberUsernmae(String number, String username) {
        return userMapper.WhetherExistByNumberUsernmae(number,username);
    }

    @Override
    public void UpdatePasswordByNumber(String number, String password) {
        userMapper.UpdatePasswordByNumber(number,password);
    }
}

package com.kaung.service;

import com.kaung.mapper.UserMapper;
import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper UserMapper;

    public void setUserMapper(com.kaung.mapper.UserMapper userMapper) {
        this.UserMapper = userMapper;
    }

    public int addUser(User User) {
        return UserMapper.addUser(User);
    }


    public int deleteUserById(int id) {
        return UserMapper.deleteUserById(id);
    }


    public int updateUser(User User) {
        return UserMapper.updateUser(User);
    }


    public User queryUserById(int id) {
        return UserMapper.queryUserById(id);
    }


    public List<User> queryAllUser() {
        return UserMapper.queryAllUser();
    }


    public List<User> findUserListByUnamePage(Integer startLine, Integer pageSize) {
        return null;
    }


    public User queryUserByName(String name) {
        return UserMapper.queryUserByName(name);
    }

    public List<User> queryUserVague(QueryInfo queryInfo) {
        return UserMapper.queryUserVague(queryInfo);
    }
}

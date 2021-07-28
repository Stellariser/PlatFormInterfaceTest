package com.kaung.mapper;

import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.User;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    User queryUserById(int id);

    List<User> queryAllUser();

    List<User> queryAllUsePage();

    User queryUserByName(String name);

    List<User> queryUserVague(QueryInfo queryInfo);
}

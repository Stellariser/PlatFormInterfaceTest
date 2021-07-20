package com.kaung.service;

import com.kaung.pogo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    User queryUserById(int id);

    List<User> queryAllUser();

    User queryUserByName(String name);
}

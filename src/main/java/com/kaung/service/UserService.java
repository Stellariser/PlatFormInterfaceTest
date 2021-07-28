package com.kaung.service;

import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    User queryUserById(int id);

    List<User> queryAllUser();
    List<User> findUserListByUnamePage(@Param("startLine") Integer startLine, @Param("pageSize") Integer pageSize);


    User queryUserByName(String name);
    List<User> queryUserVague(QueryInfo queryInfo);
}

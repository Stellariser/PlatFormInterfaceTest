package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kaung.pogo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private com.kaung.service.UserService UserService ;

    @RequestMapping(value = "/allUser", produces = "text/html;charset=utf-8")
    @ResponseBody

    public String list() throws JsonProcessingException {

        List<User> list = UserService.queryAllUser();

        return JSONObject.toJSONString(list) ;
    }
    

}

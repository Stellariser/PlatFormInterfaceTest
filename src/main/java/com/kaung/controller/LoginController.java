package com.kaung.controller;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kaung.Util.TokenUtil;
import com.kaung.pogo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private com.kaung.service.UserService UserService ;


    @RequestMapping(value = "/login", produces = "text/html;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String login(@RequestBody User loginForm) throws JsonProcessingException {
        String username=loginForm.getName();
        String password=loginForm.getPassword();
        User user = UserService.queryUserByName(username);
        int id = user.getId();
        int sta =0;
        sta =user.getStatus();
        String status = String.valueOf(sta);
        System.out.println(username+password+status);
        Boolean result = checkLogin(username,password);
        Map<String, Object> map = new HashMap<>();
        Map<String,Object> loginMap = new HashMap<>();
        System.out.println(result);
        if (result) {
            map.put("status", 200);
            map.put("msg", "登陆成功");
            map.put("token",status);
            map.put("name",username);
            map.put("id",id);
        }else{
            map.put("status", 0);
            map.put("errorInfo","登录失败，请重新登录");
        }
        loginMap.put("meta",map);
        //String maps = loginMap.toString();

        return JSONObject.toJSONString(loginMap) ;
    }


    public boolean checkLogin(String username,String password){
        User user = UserService.queryUserByName(username);
        if (user == null || "".equals(user)){
            return  false;
        }
        if (user.getPassword().equals(password)){
            return true;
        }else {
            return  false;
        }


    }
}

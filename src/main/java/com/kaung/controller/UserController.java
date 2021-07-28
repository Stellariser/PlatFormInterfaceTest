package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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


    @RequestMapping(value = "/allUserPage", produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String getPageInfo(int pageNumber, int pageSize){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        List<User> users = UserService.queryAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("meta",meta);
        data.put("totalpage",pageInfo.getTotal());
        data.put("pagenum",pageInfo.getPageNum());
        data.put("users",pageInfo.getList());
        meta.put("msg","获取成功");
        meta.put("status","200");
        //return pageInfo;
        return JSONObject.toJSONString(resultMap) ;
    }

    @RequestMapping(value = "/addUser", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody User addForm){
        UserService.addUser(addForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",UserService.queryUserByName(addForm.getName()));
        resultMap.put("meta",meta);
        meta.put("msg","用户创建成功");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getUserById", produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String addUser(int id){
        User user = UserService.queryUserById(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",user);
        resultMap.put("meta",meta);
        meta.put("msg","查询成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/editUser", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String editUser(@RequestBody User editForm){
        UserService.updateUser(editForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",editForm);
        resultMap.put("meta",meta);
        meta.put("msg","修改成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/removeUser" ,produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String deleteUser(int id){
        UserService.deleteUserById(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","删除成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/queryUserVague", produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String queryUserVague(String query,int pageNumber, int pageSize){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery(query);
        queryInfo.setPageNumber(pageNumber);
        queryInfo.setPageSize(pageSize);
        List<User> users = UserService.queryUserVague(queryInfo);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("meta",meta);
        data.put("totalpage",pageInfo.getTotal());
        data.put("pagenum",pageInfo.getPageNum());
        data.put("users",pageInfo.getList());
        meta.put("msg","获取成功");
        meta.put("status","200");
        //return pageInfo;
        return JSONObject.toJSONString(resultMap) ;
    }

}

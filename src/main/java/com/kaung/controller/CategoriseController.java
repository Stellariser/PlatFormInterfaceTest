package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaung.pogo.Classcification;
import com.kaung.pogo.Datasets;
import com.kaung.pogo.QueryInfo;

import com.kaung.pogo.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/categorise")
public class CategoriseController {
    @Autowired
    @Qualifier("ClasscificationServiceImpl")
    private com.kaung.service.ClasscificationService ClasscificationService ;
    @Autowired
    @Qualifier("SceneServiceImpl")
    private com.kaung.service.SceneService SceneService ;

    @RequestMapping(value = "/querySceneVague", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String querySceneVague(String query,int pageNumber, int pageSize){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery(query);
        queryInfo.setPageNumber(pageNumber);
        queryInfo.setPageSize(pageSize);
        List<Scene> Scene = SceneService.querySceneVague(queryInfo);
        PageInfo<Scene> pageInfo = new PageInfo<>(Scene);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("meta",meta);
        data.put("totalpage",pageInfo.getTotal());
        data.put("pagenum",pageInfo.getPageNum());
        data.put("scene",pageInfo.getList());
        meta.put("msg","获取成功");
        meta.put("status","200");
        //return pageInfo;
        return JSONObject.toJSONString(resultMap) ;
    }
    @RequestMapping(value = "/queryClasscificationVague", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryClasscificationVague(String query,int pageNumber, int pageSize){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery(query);
        queryInfo.setPageNumber(pageNumber);
        queryInfo.setPageSize(pageSize);
        List<Classcification> Classcification = ClasscificationService.queryClasscificationVague(queryInfo);
        PageInfo<Classcification> pageInfo = new PageInfo<>(Classcification);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("meta",meta);
        data.put("totalpage",pageInfo.getTotal());
        data.put("pagenum",pageInfo.getPageNum());
        data.put("classcification",pageInfo.getList());
        meta.put("msg","获取成功");
        meta.put("status","200");
        //return pageInfo;
        return JSONObject.toJSONString(resultMap) ;
    }































































































































































































































































































































































































































































































































































































































































    @RequestMapping(value = "/queryScene", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryScene(){
        List<Scene> Scene = SceneService.queryScene();
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        data.put("scene",Scene);
        resultMap.put("data",data);
        resultMap.put("meta",meta);
        meta.put("msg","获取成功");
        meta.put("status","200");
        //return pageInfo;
        return JSONObject.toJSONString(resultMap) ;
    }
}

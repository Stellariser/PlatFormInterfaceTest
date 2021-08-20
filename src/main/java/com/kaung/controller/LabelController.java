package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.kaung.pogo.Audit;
import com.kaung.pogo.FrameLabel;
import com.kaung.pogo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    @Qualifier("FrameLabelServiceImpl")
    private com.kaung.service.FrameLabelService FrameLabelService ;


    @RequestMapping(value = "/getLabelById", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String addUser(int id){
        FrameLabel FrameLabel = FrameLabelService.queryFrameLabelById(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",FrameLabel);
        resultMap.put("meta",meta);
        meta.put("msg","查询成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/editLabel", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String editUser(@RequestBody FrameLabel editForm){
        FrameLabelService.updateFrameLabel(editForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",editForm);
        resultMap.put("meta",meta);
        meta.put("msg","修改成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }
    @RequestMapping(value = "/removeLabel" ,produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String deleteUser(int id){
        FrameLabelService.deleteFrameLabelById(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","删除成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }


}

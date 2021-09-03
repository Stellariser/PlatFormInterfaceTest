package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.kaung.pogo.ClassCount;
import com.kaung.pogo.Datasets;
import com.kaung.pogo.SceneCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    @Qualifier("ClassCountServiceImpl")
    private com.kaung.service.ClassCountService ClassCountService ;
    @Autowired
    @Qualifier("SceneCountServiceImpl")
    private com.kaung.service.SceneCountService SceneCountService ;
    @Autowired
    @Qualifier("FrameProperityServiceImpl")
    private com.kaung.service.FrameProperityService FrameProperityService ;

    @RequestMapping(value = "/getClassData", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String getClassData(){
        List<ClassCount> classCount= ClassCountService.getClassCount();
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",classCount);
        resultMap.put("meta",meta);
        meta.put("msg","分类数据获取成功");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getSceneData", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String getSceneData(){
        List<SceneCount> sceneCount= SceneCountService.getSceneCount();
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",sceneCount);
        resultMap.put("meta",meta);
        meta.put("msg","场景数据获取成功");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getAmountData", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String getAmountData(){
        List<SceneCount> sceneCount= SceneCountService.getSceneCount();
        List<ClassCount> classCount= ClassCountService.getClassCount();
        int sceneAmount = sceneCount.size();
        int classAmount = classCount.size();
        int labelAmount =0;
        for(SceneCount scene:sceneCount){
            int a = scene.getScene_count();
            labelAmount = labelAmount+a;
        }
        int frameAmount = FrameProperityService.getFrameAmount();
        System.out.println(labelAmount);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("sceneCount",sceneAmount);
        resultMap.put("classAmount",classAmount);
        resultMap.put("labelAmount",labelAmount);
        resultMap.put("frameAmount",frameAmount);
        resultMap.put("meta",meta);
        meta.put("msg","场景数据获取成功");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }

}

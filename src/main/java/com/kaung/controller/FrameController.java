package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.kaung.pogo.Audit;
import com.kaung.pogo.Datasets;
import com.kaung.pogo.FrameProperity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@RestController
@RequestMapping("/frame")
public class FrameController {

    @Autowired
    @Qualifier("FrameProperityServiceImpl")
    private com.kaung.service.FrameProperityService FrameProperityService ;

    @RequestMapping(value = "/getFrameById", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String getframebyid(int id){
        FrameProperity FrameProperity = FrameProperityService.queryFrameProperityById(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",FrameProperity);
        resultMap.put("meta",meta);
        meta.put("msg","查询成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/editFrameInfo", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String editframeInfo(@RequestBody FrameProperity editForm){
        FrameProperity frameProperity = new FrameProperity();
        frameProperity.setTarget_id(editForm.getTarget_id());
        frameProperity.setPath(editForm.getPath());
        frameProperity.setId(editForm.getId());
        FrameProperityService.updateFrameProperityInfo(frameProperity);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",frameProperity);
        resultMap.put("meta",meta);
        meta.put("msg","修改成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }
    @RequestMapping(value = "/removeFrame" ,produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String deleteUser(int id){
        FrameProperityService.deleteFrameProperityById(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","删除成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }

    /*@RequestMapping(value = "/addFrameAudit", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String addAudit(@RequestBody Audit addForm){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        addForm.setCreate_time(now);
        addForm.setStatus("未审核");
        addForm.setType("添加数据集");
        addForm.setDataset_id(addForm.getId());
        System.out.println(addForm.toString());
        AuditService.addAudit(addForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",AuditService.queryAuditByName(addForm.getDataset_name()));
        resultMap.put("meta",meta);
        meta.put("msg","用户创建成功");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }
*/
}

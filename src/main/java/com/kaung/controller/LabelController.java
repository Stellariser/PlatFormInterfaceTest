package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaung.pogo.*;
import com.kaung.service.LabelAuditService;
import com.kaung.vo.DenyForm;
import com.kaung.vo.FrameAddForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    @Qualifier("ClasscificationServiceImpl")
    private com.kaung.service.ClasscificationService ClasscificationService ;
    @Autowired
    @Qualifier("SceneServiceImpl")
    private com.kaung.service.SceneService SceneService ;
    @Autowired
    @Qualifier("FrameLabelServiceImpl")
    private com.kaung.service.FrameLabelService FrameLabelService ;
    @Autowired
    @Qualifier("LabelAuditServiceImpl")
    private com.kaung.service.LabelAuditService LabelAuditService ;

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
    public String editUser(@RequestBody LabelAudit editForm){
        System.out.println(editForm);
        LabelAudit labelAudit = new LabelAudit();
        labelAudit.setFrame_id(editForm.getFrame_id());
        labelAudit.setLabel_id(editForm.getLabel_id());
        labelAudit.setClassification_id(editForm.getClassification_id());
        labelAudit.setScene_id(editForm.getScene_id());
        labelAudit.setLeft_point_x(editForm.getLeft_point_x());
        labelAudit.setLeft_point_y(editForm.getLeft_point_y());
        labelAudit.setRight_point_x(editForm.getRight_point_x());
        labelAudit.setRight_point_y(editForm.getRight_point_y());
        labelAudit.setCentre_point_x(editForm.getCentre_point_x());
        labelAudit.setCentre_point_y(editForm.getCentre_point_y());
        labelAudit.setWidth(editForm.getWidth());
        labelAudit.setHeight(editForm.getHeight());
        labelAudit.setPath(editForm.getPath());
        labelAudit.setAudit_time(editForm.getAudit_time());
        labelAudit.setAuditor(editForm.getAuditor());
        labelAudit.setType(editForm.getType());
        labelAudit.setStatus(editForm.getStatus());
        labelAudit.setClassname(ClasscificationService.queryClasscificationById(editForm.getClassification_id()).getClass_name());
        labelAudit.setScenename(SceneService.querySceneById(editForm.getScene_id()).getScene_name());
        labelAudit.setType("修改标签");
        labelAudit.setStatus("未审核");
        LabelAuditService.addLabelAudit(labelAudit);
        //FrameLabelService.updateFrameLabel(editForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",editForm);
        resultMap.put("meta",meta);
        meta.put("msg","修改标签审核提交成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }
    @RequestMapping(value = "/RemoveLabel", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String removeLabel(@RequestBody LabelAudit editForm){
        System.out.println(editForm);
        LabelAudit labelAudit = new LabelAudit();
        labelAudit.setFrame_id(editForm.getFrame_id());
        labelAudit.setLabel_id(editForm.getLabel_id());
        labelAudit.setClassification_id(editForm.getClassification_id());
        labelAudit.setScene_id(editForm.getScene_id());
        labelAudit.setLeft_point_x(editForm.getLeft_point_x());
        labelAudit.setLeft_point_y(editForm.getLeft_point_y());
        labelAudit.setRight_point_x(editForm.getRight_point_x());
        labelAudit.setRight_point_y(editForm.getRight_point_y());
        labelAudit.setCentre_point_x(editForm.getCentre_point_x());
        labelAudit.setCentre_point_y(editForm.getCentre_point_y());
        labelAudit.setWidth(editForm.getWidth());
        labelAudit.setHeight(editForm.getHeight());
        labelAudit.setPath(editForm.getPath());
        labelAudit.setAudit_time(editForm.getAudit_time());
        labelAudit.setAuditor(editForm.getAuditor());
        labelAudit.setType(editForm.getType());
        labelAudit.setStatus(editForm.getStatus());
        labelAudit.setClassname(ClasscificationService.queryClasscificationById(editForm.getClassification_id()).getClass_name());
        labelAudit.setScenename(SceneService.querySceneById(editForm.getScene_id()).getScene_name());
        labelAudit.setType("删除标签");
        labelAudit.setStatus("未审核");
        LabelAuditService.addLabelAudit(labelAudit);
        //FrameLabelService.updateFrameLabel(editForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",editForm);
        resultMap.put("meta",meta);
        meta.put("msg","删除审核提交成功");
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
    @RequestMapping(value = "/queryLabelAuditVague", produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryLabelAuditVague(String query,int pageNumber, int pageSize){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery(query);
        queryInfo.setPageNumber(pageNumber);
        queryInfo.setPageSize(pageSize);
        List<LabelAudit> LabelAudit = LabelAuditService.queryAllLabelAudit();
        PageInfo<LabelAudit> pageInfo = new PageInfo<>(LabelAudit);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("meta",meta);
        data.put("totalpage",pageInfo.getTotal());
        data.put("pagenum",pageInfo.getPageNum());
        data.put("audit",pageInfo.getList());
        meta.put("msg","获取成功");
        meta.put("status","200");
        //return pageInfo;
        return JSONObject.toJSONString(resultMap) ;
    }

    @RequestMapping(value = "/getLabelAuditById", produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String getFrameAuditById(int id){

        LabelAudit LabelAudit = LabelAuditService.queryLabelAuditById(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",LabelAudit);
        resultMap.put("meta",meta);
        if(LabelAudit !=null){
            meta.put("msg","查询成功");
            meta.put("status","200");
        }else {
            meta.put("msg","查询失败");
            meta.put("status","500");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/editLabelAudit", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String editFrameAudit(@RequestBody LabelAudit editForm){
        System.out.println(editForm);
        LabelAudit labelAudit = new LabelAudit();
        labelAudit.setId(editForm.getId());
        labelAudit.setClassification_id(editForm.getClassification_id());
        labelAudit.setScene_id(editForm.getScene_id());
        labelAudit.setLeft_point_x(editForm.getLeft_point_x());
        labelAudit.setLeft_point_y(editForm.getLeft_point_y());
        labelAudit.setRight_point_x(editForm.getRight_point_x());
        labelAudit.setRight_point_y(editForm.getRight_point_y());
        labelAudit.setCentre_point_x(editForm.getCentre_point_x());
        labelAudit.setCentre_point_y(editForm.getCentre_point_y());
        labelAudit.setWidth(editForm.getWidth());
        labelAudit.setHeight(editForm.getHeight());
        labelAudit.setPath(editForm.getPath());
        labelAudit.setAudit_time(editForm.getAudit_time());
        labelAudit.setAuditor(editForm.getAuditor());
        labelAudit.setType(editForm.getType());
        labelAudit.setStatus(editForm.getStatus());
        labelAudit.setClassname(ClasscificationService.queryClasscificationById(editForm.getClassification_id()).getClass_name());
        labelAudit.setScenename(SceneService.querySceneById(editForm.getScene_id()).getScene_name());
        LabelAuditService.updateLabelAudit(labelAudit);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",editForm);
        resultMap.put("meta",meta);
        meta.put("msg","修改成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }
    @RequestMapping(value = "/approveLabel", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String addframe(@RequestBody LabelAudit approveForm){
        System.out.println(approveForm);
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        approveForm.setAudit_time(now);
        FrameLabel frameLabel = new FrameLabel();
        if(approveForm.getType().equals("添加标签")) {
            frameLabel.setFrame_id(approveForm.getFrame_id());
            frameLabel.setClassification_id(approveForm.getClassification_id());
            frameLabel.setScene_id(approveForm.getScene_id());
            frameLabel.setLeft_point_y(approveForm.getLeft_point_y());
            frameLabel.setLeft_point_x(approveForm.getLeft_point_x());
            frameLabel.setRight_point_y(approveForm.getRight_point_y());
            frameLabel.setRight_point_x(approveForm.getRight_point_x());
            frameLabel.setCentre_point_y(approveForm.getCentre_point_y());
            frameLabel.setCentre_point_x(approveForm.getCentre_point_x());
            frameLabel.setWidth(approveForm.getWidth());
            frameLabel.setHeight(approveForm.getHeight());
            frameLabel.setPath(approveForm.getPath());
            FrameLabelService.addFrameLabel(frameLabel);
        }
        if(approveForm.getType().equals("修改标签")){
            frameLabel.setId(approveForm.getLabel_id());
            frameLabel.setFrame_id(approveForm.getFrame_id());
            frameLabel.setClassification_id(approveForm.getClassification_id());
            frameLabel.setScene_id(approveForm.getScene_id());
            frameLabel.setLeft_point_y(approveForm.getLeft_point_y());
            frameLabel.setLeft_point_x(approveForm.getLeft_point_x());
            frameLabel.setRight_point_y(approveForm.getRight_point_y());
            frameLabel.setRight_point_x(approveForm.getRight_point_x());
            frameLabel.setCentre_point_y(approveForm.getCentre_point_y());
            frameLabel.setCentre_point_x(approveForm.getCentre_point_x());
            frameLabel.setWidth(approveForm.getWidth());
            frameLabel.setHeight(approveForm.getHeight());
            frameLabel.setPath(approveForm.getPath());
            FrameLabelService.updateFrameLabel(frameLabel);
        }
        if(approveForm.getType().equals("删除标签")){
            int id = approveForm.getLabel_id();
            FrameLabelService.deleteFrameLabelById(id);

        }
        approveForm.setStatus("已审核");
        LabelAuditService.updateLabelAudit(approveForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data", "成功");
        resultMap.put("meta",meta);
        meta.put("msg","审核通过");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/denyLabel" ,produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String denyFrameAudit(int id,String name){
        DenyForm denyForm = new DenyForm();
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        denyForm.setId(id);
        denyForm.setAuditor(name);
        denyForm.setAudit_time(now);
        denyForm.setStatus("已驳回");
        LabelAuditService.Deny(denyForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","驳回成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }


}

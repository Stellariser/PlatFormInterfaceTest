package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaung.pogo.Audit;
import com.kaung.pogo.Datasets;
import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.User;
import com.kaung.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {
    @Autowired
    @Qualifier("AuditServiceImpl")
    private com.kaung.service.AuditService AuditService ;
    @Autowired
    @Qualifier("DatasetsServiceImpl")
    private com.kaung.service.DatasetsService DatasetsService ;


    @RequestMapping(value = "/addDatasetAudit", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
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
    @RequestMapping(value = "/editDatasetAudit", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String addeditdatasetAudit(@RequestBody Audit editForm){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        editForm.setCreate_time(now);
        editForm.setStatus("未审核");
        editForm.setType("修改数据集");
        editForm.setModify_time(now);
        editForm.setDataset_id(editForm.getId());
        System.out.println(editForm.toString());
        AuditService.addAudit(editForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","用户创建成功");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/queryAuditVague", produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String queryAuditVague(String query,int pageNumber, int pageSize){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery(query);
        queryInfo.setPageNumber(pageNumber);
        queryInfo.setPageSize(pageSize);
        List<Audit> Audit = AuditService.queryAllAudit();
        PageInfo<Audit> pageInfo = new PageInfo<>(Audit);
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
    @RequestMapping(value = "/getAuditById", produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String getAuditById(int id){

        Audit Audit = AuditService.queryAuditById(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",Audit);
        resultMap.put("meta",meta);
        if(Audit !=null){
        meta.put("msg","查询成功");
        meta.put("status","200");
        }else {
            meta.put("msg","查询失败");
            meta.put("status","500");
        }

        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/editAudit", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String editUser(@RequestBody Audit editForm){
        AuditService.updateAudit(editForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",editForm);
        resultMap.put("meta",meta);
        meta.put("msg","修改成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/approve", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody Audit approveForm){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        approveForm.setAudit_time(now);
        Datasets d = new Datasets();
        if(approveForm.getType().equals("添加数据集")) {
            d.setName(approveForm.getDataset_name());
            d.setFrames(approveForm.getSize());
            d.setRemarks(approveForm.getRemark());
            d.setPurpose(approveForm.getPurpose());
            d.setPath(approveForm.getPath());
            d.setRecorder(approveForm.getRecorder());
            d.setRecord_place(approveForm.getRecord_place());
            d.setRecord_time(approveForm.getRecord_time());
            d.setCreate_person(approveForm.getCreate_person());
            d.setCreate_time(approveForm.getCreate_time());
            d.setUpdate_person(approveForm.getAuditor());
            d.setUpdate_time(approveForm.getAudit_time());
            if (approveForm.getStatus().equals("未审核")) {
                DatasetsService.addDatasets(d);
            }
        }
        if(approveForm.getType().equals("修改数据集")){
            System.out.println(approveForm);
            d.setId(approveForm.getDataset_id());
            d.setName(approveForm.getDataset_name());
            d.setFrames(approveForm.getSize());
            d.setRemarks(approveForm.getRemark());
            d.setPurpose(approveForm.getPurpose());
            d.setPath(approveForm.getPath());
            d.setRecorder(approveForm.getRecorder());
            d.setRecord_place(approveForm.getRecord_place());
            d.setRecord_time(approveForm.getRecord_time());
            d.setCreate_person(approveForm.getCreate_person());
            d.setCreate_time(approveForm.getCreate_time());
            d.setUpdate_person(approveForm.getModifier());
            d.setUpdate_time(approveForm.getModify_time());
            System.out.println(d);
            if (approveForm.getStatus().equals("未审核")) {
                DatasetsService.updateDatasets(d);
            }

        }
        approveForm.setStatus("已审核");
        AuditService.updateAudit(approveForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data", "成功");
        resultMap.put("meta",meta);
        meta.put("msg","审核通过");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/deny" ,produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String deleteAudit(@RequestBody Audit approveForm){
        approveForm.setStatus("已驳回");
        AuditService.updateAudit(approveForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","驳回成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }













}

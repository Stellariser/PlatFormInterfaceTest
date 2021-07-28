package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaung.pogo.Datasets;
import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/datasets")
public class DatasetController {

    @Autowired
    @Qualifier("DatasetsServiceImpl")
    private com.kaung.service.DatasetsService DatasetsService ;

    @RequestMapping(value = "/queryDatasetsVague", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryDatasetsVague(String query,int pageNumber, int pageSize){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery(query);
        queryInfo.setPageNumber(pageNumber);
        queryInfo.setPageSize(pageSize);
        List<Datasets> Datasets = DatasetsService.queryDatasetsVague(queryInfo);
        PageInfo<Datasets> pageInfo = new PageInfo<>(Datasets);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("meta",meta);
        data.put("totalpage",pageInfo.getTotal());
        data.put("pagenum",pageInfo.getPageNum());
        data.put("datasets",pageInfo.getList());
        meta.put("msg","获取成功");
        meta.put("status","200");
        //return pageInfo;
        return JSONObject.toJSONString(resultMap) ;
    }
    @RequestMapping(value = "/addDataset", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String addDataset(@RequestBody Datasets addForm){
        DatasetsService.addDatasets(addForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",DatasetsService.queryDatasetsByName(addForm.getName()));
        resultMap.put("meta",meta);
        meta.put("msg","数据集创建成功");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }







}

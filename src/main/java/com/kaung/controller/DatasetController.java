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
    public String queryDatasetsVague(String query,int pageNumber, int pageSize, String VSString, String VCString){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQuery(query);
        queryInfo.setPageNumber(pageNumber);
        queryInfo.setPageSize(pageSize);
        System.out.println(VSString);
        System.out.println(VCString);
        if(! VSString.equals("[]") ) {
            VSString = VSString.replaceAll("\\[", "");
            VSString = VSString.replaceAll("\\]", "");
            String[] VSS = VSString.split(",");
            int[] VSSI = new int [VSS.length];
            for(int i=0 ; i<VSS.length;i++){ ;
                VSSI[i] = Integer.parseInt(VSS[i]);
            }
            queryInfo.setSceneList(VSSI);
        }else queryInfo.setSceneList(null);
        if(!VCString.equals("[]")) {
            VCString = VCString.replaceAll("\\[", "");
            VCString = VCString.replaceAll("\\]", "");
            String[] VCS = VCString.split(",");
            int[] VCSI = new int [VCS.length];
            for(int i=0 ; i<VCS.length;i++){ ;
                VCSI[i] = Integer.parseInt(VCS[i]);
            }
            queryInfo.setClasscificationList(VCSI);
        }else queryInfo.setClasscificationList(null);
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
    @RequestMapping(value = "/getDatasetById", produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    public String getdatasetbyid(int id){
        Datasets Datasets = DatasetsService.queryDatasetsById(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",Datasets);
        resultMap.put("meta",meta);
        meta.put("msg","查询成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }


    @RequestMapping(value = "/editDataset", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String editUser(@RequestBody Datasets editForm){
        DatasetsService.updateDatasets(editForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",editForm);
        resultMap.put("meta",meta);
        meta.put("msg","修改成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }



}

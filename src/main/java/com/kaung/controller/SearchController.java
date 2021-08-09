package com.kaung.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaung.pogo.Datasets;
import com.kaung.pogo.FrameProperity;
import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.Type;
import com.kaung.vo.ProperityQueryInfo;
import org.bouncycastle.util.Integers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    @Qualifier("FrameProperityServiceImpl")
    private com.kaung.service.FrameProperityService FrameProperityService ;


    @RequestMapping(value = "/queryFrame", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryDatasetsVague(String query, int pageNumber, int pageSize, String VSString, String VCString, String VDString){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        ProperityQueryInfo ProperityQueryInfo = new ProperityQueryInfo();
        ProperityQueryInfo.setQuery(query);
        ProperityQueryInfo.setPageNumber(pageNumber);
        ProperityQueryInfo.setPageSize(pageSize);
        System.out.println(VSString);
        System.out.println(VCString);
        System.out.println(VDString);
        /*VSString = VSString.replaceAll("\\[", "");
        VSString = VSString.replaceAll("\\]", "");
        String[] VSS = VSString.split(",");
        VCString = VCString.replaceAll("\\[", "");
        VCString = VCString.replaceAll("\\]", "");
        String[] VCS = VCString.split(",");
        VDString = VDString.replaceAll("\\[", "");
        VDString = VDString.replaceAll("\\]", "");
        String[] VDS = VDString.split(",");
        int[] VSSI = new int [VSS.length];
        int[] VCSI = new int [VCS.length];
        int[] VDSI = new int [VDS.length];
        for(int i=0 ; i<VSS.length;i++){ ;
            VSSI[i] = Integer.parseInt(VSS[i]);
        }
        for(int i=0 ; i<VCS.length;i++){ ;
            VCSI[i] = Integer.parseInt(VCS[i]);
        }
        for(int i=0 ; i<VDS.length;i++){ ;
            VDSI[i] = Integer.parseInt(VDS[i]);
        }*/
        if(! VSString.equals("[]") ) {
            VSString = VSString.replaceAll("\\[", "");
            VSString = VSString.replaceAll("\\]", "");
            String[] VSS = VSString.split(",");
            int[] VSSI = new int [VSS.length];
            for(int i=0 ; i<VSS.length;i++){ ;
                VSSI[i] = Integer.parseInt(VSS[i]);
            }
            ProperityQueryInfo.setSceneList(VSSI);
        }else ProperityQueryInfo.setSceneList(null);
        if(!VCString.equals("[]")) {
            VCString = VCString.replaceAll("\\[", "");
            VCString = VCString.replaceAll("\\]", "");
            String[] VCS = VCString.split(",");
            int[] VCSI = new int [VCS.length];
            for(int i=0 ; i<VCS.length;i++){ ;
                VCSI[i] = Integer.parseInt(VCS[i]);
            }
            ProperityQueryInfo.setClasscificationList(VCSI);
        }else ProperityQueryInfo.setClasscificationList(null);
        if(!VDString.equals("[]")) {
            VDString = VDString.replaceAll("\\[", "");
            VDString = VDString.replaceAll("\\]", "");
            String[] VDS = VDString.split(",");
            int[] VDSI = new int [VDS.length];
            for(int i=0 ; i<VDS.length;i++){ ;
                VDSI[i] = Integer.parseInt(VDS[i]);
            }
            ProperityQueryInfo.setDatasetList(VDSI);
        }else ProperityQueryInfo.setDatasetList(null);
        List<FrameProperity> FrameProperity = FrameProperityService.queryGlobalFrame(ProperityQueryInfo);
        PageInfo<FrameProperity> pageInfo = new PageInfo<>(FrameProperity);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("meta",meta);
        data.put("totalpage",pageInfo.getTotal());
        data.put("pagenum",pageInfo.getPageNum());
        data.put("Frames",pageInfo.getList());
        meta.put("msg","获取成功");
        meta.put("status","200");
        //return pageInfo;
        return JSONObject.toJSONString(resultMap) ;
    }


}

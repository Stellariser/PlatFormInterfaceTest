package com.kaung.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaung.pogo.*;
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

    @Autowired
    @Qualifier("FrameLabelServiceImpl")
    private com.kaung.service.FrameLabelService FrameLabelService ;


    @RequestMapping(value = "/queryFrame", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryDatasetsVague(String query, int pageNumber, int pageSize, String VSString, String VCString, String VDString, String VNCString, String VNSString,String extendLabel,String VTString,String VNTString){
        System.out.println(extendLabel);
        System.out.println(VTString);
        System.out.println(VNTString);
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

        if(! VNSString.equals("[]") ) {
            VNSString = VNSString.replaceAll("\\[", "");
            VNSString = VNSString.replaceAll("\\]", "");
            String[] VNSS = VNSString.split(",");
            int[] VNSSI = new int [VNSS.length];
            for(int i=0 ; i<VNSS.length;i++){ ;
                VNSSI[i] = Integer.parseInt(VNSS[i]);
            }
            ProperityQueryInfo.setNosceneList(VNSSI);
        }else ProperityQueryInfo.setNosceneList(null);

        if(! VNCString.equals("[]") ) {
            VNCString = VNCString.replaceAll("\\[", "");
            VNCString = VNCString.replaceAll("\\]", "");
            String[] VNCS = VNCString.split(",");
            int[] VNCSI = new int [VNCS.length];
            for(int i=0 ; i<VNCS.length;i++){ ;
                VNCSI[i] = Integer.parseInt(VNCS[i]);
            }
            ProperityQueryInfo.setNoclasscificationList(VNCSI);
        }else ProperityQueryInfo.setNoclasscificationList(null);

        if(! VTString.equals("[]") ) {
            VTString = VTString.replaceAll("\\[", "");
            VTString = VTString.replaceAll("\\]", "");
            String[] VTS = VTString.split(",");
            int[] VTSI = new int [VTS.length];
            for(int i=0 ; i<VTS.length;i++){ ;
                VTSI[i] = Integer.parseInt(VTS[i]);
            }
            ProperityQueryInfo.setTagList(VTSI);
        }else ProperityQueryInfo.setTagList(null);

        if(! VNTString.equals("[]") ) {
            VNTString = VNTString.replaceAll("\\[", "");
            VNTString = VNTString.replaceAll("\\]", "");
            String[] VNTS = VNTString.split(",");
            int[] VNTSI = new int [VNTS.length];
            for(int i=0 ; i<VNTS.length;i++){ ;
                VNTSI[i] = Integer.parseInt(VNTS[i]);
            }
            ProperityQueryInfo.setNoTagList(VNTSI);
        }else ProperityQueryInfo.setNoTagList(null);

        ProperityQueryInfo.setExtendLabel(extendLabel);
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

    @RequestMapping(value = "/queryLabel", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryDatasetsVague(String VFString, int pageNumber, int pageSize){
        //掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber,pageSize);
        LabelQueryInfo LabelQueryInfo = new LabelQueryInfo();
        LabelQueryInfo.setPageNumber(pageNumber);
        LabelQueryInfo.setPageSize(pageSize);
        if(! VFString.equals("[]") ) {
            VFString = VFString.replaceAll("\\[", "");
            VFString = VFString.replaceAll("\\]", "");
            int a = Integer.parseInt(VFString);
            LabelQueryInfo.setFrame_id(a);
        }else LabelQueryInfo.setFrame_id(0);
        List<FrameLabel> FrameLabel = FrameLabelService.queryFrameLabelByName(LabelQueryInfo);
        PageInfo<FrameLabel> pageInfo = new PageInfo<>(FrameLabel);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("meta",meta);
        data.put("totalpage",pageInfo.getTotal());
        data.put("pagenum",pageInfo.getPageNum());
        data.put("Labels",pageInfo.getList());
        meta.put("msg","获取成功");
        meta.put("status","200");
        //return pageInfo;
        return JSONObject.toJSONString(resultMap) ;
    }
}

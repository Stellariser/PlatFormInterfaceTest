package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaung.pogo.*;
import com.kaung.service.AuditService;
import com.kaung.service.FrameProperityService;
import com.kaung.vo.FrameAddForm;
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

    @Autowired
    @Qualifier("FrameProperityServiceImpl")
    private com.kaung.service.FrameProperityService FrameProperityService ;

    @Autowired
    @Qualifier("FrameToClassServiceImpl")
    private com.kaung.service.FrameToClassService FrameToClassService ;
    @Autowired
    @Qualifier("FrameToSceneServiceImpl")
    private com.kaung.service.FrameToSceneService FrameToSceneService ;
    @Autowired
    @Qualifier("TagToFrameServiceImpl")
    private com.kaung.service.TagToFrameService TagToFrameService ;
    @Autowired
    @Qualifier("DatasetToClasscificationServiceImpl")
    private com.kaung.service.DatasetToClasscificationService DatasetToClasscificationService ;
    @Autowired
    @Qualifier("DatasetToSceneServiceImpl")
    private com.kaung.service.DatasetToSceneService DatasetToSceneService ;
    @Autowired
    @Qualifier("FrameLabelServiceImpl")
    private com.kaung.service.FrameLabelService FrameLabelService ;

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
        Datasets admin = new Datasets();
        if(approveForm.getType().equals("添加数据集")) {
            admin.setName(approveForm.getDataset_name());
            admin.setFrames(approveForm.getSize());
            admin.setRemarks(approveForm.getRemark());
            admin.setPurpose(approveForm.getPurpose());
            admin.setPath(approveForm.getPath());
            admin.setRecorder(approveForm.getRecorder());
            admin.setRecord_place(approveForm.getRecord_place());
            admin.setRecord_time(approveForm.getRecord_time());
            admin.setCreate_person(approveForm.getCreate_person());
            admin.setCreate_time(approveForm.getCreate_time());
            admin.setUpdate_person(approveForm.getAuditor());
            admin.setUpdate_time(now);
            admin.setId(0);
            System.out.println(admin);
            DatasetsService.addDatasets(admin);
        }
        System.out.println("tyutrutrutr");
        if(approveForm.getType().equals("修改数据集")){
            System.out.println(approveForm);
            admin.setId(approveForm.getDataset_id());
            admin.setName(approveForm.getDataset_name());
            admin.setFrames(approveForm.getSize());
            admin.setRemarks(approveForm.getRemark());
            admin.setPurpose(approveForm.getPurpose());
            admin.setPath(approveForm.getPath());
            admin.setRecorder(approveForm.getRecorder());
            admin.setRecord_place(approveForm.getRecord_place());
            admin.setRecord_time(approveForm.getRecord_time());
            admin.setCreate_person(approveForm.getCreate_person());
            admin.setCreate_time(approveForm.getCreate_time());
            admin.setUpdate_person(approveForm.getModifier());
            admin.setUpdate_time(approveForm.getModify_time());
            System.out.println(admin);
            DatasetsService.updateDatasets(admin);
            System.out.println(admin);

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


    @RequestMapping(value = "/addFrameAudit", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String addAudit(int datasetid,String classcification,String scene,String tag,String create_person,String create_time, String path,String target){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        FrameAddForm frameAddForm = new FrameAddForm();
        System.out.println(datasetid);
        frameAddForm.setDatasetid(datasetid);
        if(! classcification.equals("[]") ) {
            classcification = classcification.replaceAll("\\[", "");
            classcification = classcification.replaceAll("\\]", "");
            String[] CS = classcification.split(",");
            int[] CSI = new int [CS.length];
            for(int i=0 ; i<CS.length;i++){ ;
                CSI[i] = Integer.parseInt(CS[i]);
            }
            frameAddForm.setClasscification(CSI);
        }else frameAddForm.setClasscification(null);
        if(! scene.equals("[]") ) {
            scene = scene.replaceAll("\\[", "");
            scene = scene.replaceAll("\\]", "");
            String[] SS = scene.split(",");
            int[] SSI = new int [SS.length];
            for(int i=0 ; i<SS.length;i++){ ;
                SSI[i] = Integer.parseInt(SS[i]);
            }
            frameAddForm.setScene(SSI);
        }else frameAddForm.setScene(null);
        if(! tag.equals("[]") ) {
            tag = tag.replaceAll("\\[", "");
            tag = tag.replaceAll("\\]", "");
            String[] TS = tag.split(",");
            int[] TSI = new int [TS.length];
            for(int i=0 ; i<TS.length;i++){ ;
                TSI[i] = Integer.parseInt(TS[i]);
            }
            frameAddForm.setTag(TSI);
        }else frameAddForm.setTag(null);
        frameAddForm.setCreate_person(create_person);
        frameAddForm.setCreate_time(now);
        frameAddForm.setPath(path);
        frameAddForm.setTarget(target);
        System.out.println(frameAddForm.toString());
        FrameProperityService.addFrameProperity(frameAddForm);
        int frameid = FrameProperityService.getLastInsert();
        System.out.println(frameid);
        FrameToScene frameToScene = new FrameToScene();
        frameToScene.setFrame_id(frameid);
        if(frameAddForm.getScene()!=null){
            int[] scenelist = frameAddForm.getScene();

            for(int i=0;i<scenelist.length;i++){
                frameToScene.setScene_id_id(scenelist[i]);
                FrameToSceneService.addFrameToScene(frameToScene);
            }
        }
        FrameToClass frameToClass = new FrameToClass();
        frameToClass.setFrame_id(frameid);
        if(frameAddForm.getClasscification()!=null){
            int[] Classlist = frameAddForm.getClasscification();

            for(int i=0;i<Classlist.length;i++){
                frameToClass.setClass_id_id(Classlist[i]);
                FrameToClassService.addFrameToClass(frameToClass);
            }
        }
        TagToFrame tagToFrame =new TagToFrame();
        tagToFrame.setFrame_id(frameid);
        if(frameAddForm.getTag()!=null){
            int[] taglist = frameAddForm.getTag();
            for(int i=0;i<taglist.length;i++){
                tagToFrame.setTag_id(taglist[i]);
                TagToFrameService.addTagToFrame(tagToFrame);
            }
        }
        DatasetToScene datasetToScene = new DatasetToScene();
        datasetToScene.setDataset_id(frameAddForm.getDatasetid());
        if(frameAddForm.getScene()!=null){
            int[] scenelist = frameAddForm.getScene();

            for(int i=0;i<scenelist.length;i++){
                datasetToScene.setScene_id(scenelist[i]);
                DatasetToSceneService.addDatasetToScene(datasetToScene);
            }
        }
        DatasetToClasscification datasetToClasscification= new DatasetToClasscification();
        datasetToClasscification.setDataset_id(frameAddForm.getDatasetid());
        if(frameAddForm.getClasscification()!=null){
            int[] Classlist = frameAddForm.getClasscification();

            for(int i=0;i<Classlist.length;i++){
                datasetToClasscification.setClasscification_id(Classlist[i]);
                DatasetToClasscificationService.addDatasetToClasscification(datasetToClasscification);
            }
        }
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","用户创建成功");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/addLabelAudit", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String addAudit(@RequestBody FrameLabel addForm){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        FrameLabel frameLabel = new FrameLabel();
        frameLabel.setFrame_id(addForm.getFrame_id());
        frameLabel.setScene_id(addForm.getScene_id());
        frameLabel.setClassification_id(addForm.getClassification_id());
        frameLabel.setCentre_point_x(addForm.getCentre_point_x());
        frameLabel.setCentre_point_y(addForm.getCentre_point_y());
        frameLabel.setLeft_point_x(addForm.getLeft_point_x());
        frameLabel.setLeft_point_y(addForm.getLeft_point_y());
        frameLabel.setRight_point_x(addForm.getRight_point_x());
        frameLabel.setRight_point_y(addForm.getRight_point_y());
        frameLabel.setPath(addForm.getPath());
        frameLabel.setHeight(addForm.getHeight());
        frameLabel.setWidth(addForm.getWidth());
        FrameLabelService.addFrameLabel(frameLabel);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","标签成功");
        meta.put("status","201");
        return JSONObject.toJSONString(resultMap);
    }



}

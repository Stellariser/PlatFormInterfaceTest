package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.kaung.pogo.Audit;
import com.kaung.pogo.Datasets;
import com.kaung.pogo.FrameAudit;
import com.kaung.pogo.FrameProperity;
import com.kaung.service.FrameAuditService;
import com.kaung.vo.DenyForm;
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
    @Qualifier("ClasscificationServiceImpl")
    private com.kaung.service.ClasscificationService ClasscificationService ;
    @Autowired
    @Qualifier("SceneServiceImpl")
    private com.kaung.service.SceneService SceneService ;
    @Autowired
    @Qualifier("TagServiceImpl")
    private com.kaung.service.TagService TagService ;
    @Autowired
    @Qualifier("FrameProperityServiceImpl")
    private com.kaung.service.FrameProperityService FrameProperityService ;
    @Autowired
    @Qualifier("FrameAuditServiceImpl")
    private com.kaung.service.FrameAuditService FrameAuditService ;

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
    public String editframeInfo(@RequestBody FrameAudit editForm){
        System.out.println(editForm);
        String classcification = editForm.getClasslist().toString();
        if (!classcification.equals("[]")) {
            classcification = classcification.replaceAll("\\[", "");
            classcification = classcification.replaceAll("\\]", "");
            String[] CS = classcification.split(",");
            int[] CSI = new int[CS.length];
            String[] classname = new String[CS.length];
            StringBuffer S = new StringBuffer();
            for (int i = 0; i < CS.length; i++) {
                CSI[i] = Integer.parseInt(CS[i]);
            }
            for (int j = 0; j < CSI.length; j++) {
                classname[j] = ClasscificationService.queryClasscificationById(CSI[j]).getClass_name();
                S.append(classname[j]);
                S.append(",");
            }
            editForm.setClasscontent(S.toString());
        } else editForm.setClasscontent("");

        String scene = editForm.getScenelist().toString();
        if (!scene.equals("[]")) {
            scene = scene.replaceAll("\\[", "");
            scene = scene.replaceAll("\\]", "");
            String[] SS = scene.split(",");
            int[] SSI = new int[SS.length];
            String[] scenename = new String[SS.length];
            StringBuffer S = new StringBuffer();
            for (int i = 0; i < SS.length; i++) {
                SSI[i] = Integer.parseInt(SS[i]);
            }
            for (int j = 0; j < SSI.length; j++) {
                scenename[j] = SceneService.querySceneById(SSI[j]).getScene_name();
                S.append(scenename[j]);
                S.append(",");
            }
            editForm.setScenecontent(S.toString());
        } else editForm.setScenecontent("");
        String tag = editForm.getTaglist().toString();
        if (!tag.equals("[]")) {
            tag = tag.replaceAll("\\[", "");
            tag = tag.replaceAll("\\]", "");
            String[] TS = tag.split(",");
            int[] TSI = new int[TS.length];
            String[] tagname = new String[TS.length];
            StringBuffer S = new StringBuffer();
            for (int i = 0; i < TS.length; i++) {
                TSI[i] = Integer.parseInt(TS[i]);
            }
            for (int j = 0; j < TSI.length; j++) {
                tagname[j] = TagService.queryTagById(TSI[j]).getTag_name();
                S.append(tagname[j]);
                S.append(",");
            }
            editForm.setTagcontent(S.toString());
        } else editForm.setTagcontent("");
        System.out.println(editForm);
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        FrameAudit frameAudit = new FrameAudit();
        frameAudit.setFrame_id(editForm.getId());
        frameAudit.setDataset_id(editForm.getDataset_id());
        frameAudit.setCreate_person(editForm.getCreate_person());
        frameAudit.setCreate_time(editForm.getCreate_time());
        frameAudit.setPath(editForm.getPath());
        frameAudit.setTarget_id(editForm.getTarget_id());
        frameAudit.setType("修改帧");
        frameAudit.setClasscontent(editForm.getClasscontent());
        frameAudit.setScenecontent(editForm.getScenecontent());
        frameAudit.setTagcontent(editForm.getTagcontent());
        frameAudit.setStatus("未审核");
        frameAudit.setUpdate_person(editForm.getUpdate_person());
        frameAudit.setUpdate_time(now);
        frameAudit.setScenelist(editForm.getScenelist());
        frameAudit.setClasslist(editForm.getClasslist());
        frameAudit.setTaglist(editForm.getTaglist());
        FrameAuditService.addFrameAudit(frameAudit);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","修改帧审核提交成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }
    @RequestMapping(value = "/RemoveFrameInfo", produces = "text/html;charset=utf-8", method =RequestMethod.POST)
    @ResponseBody
    public String removeframeInfo(@RequestBody FrameAudit editForm){
        System.out.println(editForm);
        String classcification;
        if(!editForm.getClasslist().equals(null)){
            classcification = editForm.getClasslist().toString();
        }else
            classcification="[]";
        if (!classcification.equals("[]")) {
            classcification = classcification.replaceAll("\\[", "");
            classcification = classcification.replaceAll("\\]", "");
            String[] CS = classcification.split(",");
            int[] CSI = new int[CS.length];
            String[] classname = new String[CS.length];
            StringBuffer S = new StringBuffer();
            for (int i = 0; i < CS.length; i++) {
                CSI[i] = Integer.parseInt(CS[i]);
            }
            for (int j = 0; j < CSI.length; j++) {
                classname[j] = ClasscificationService.queryClasscificationById(CSI[j]).getClass_name();
                S.append(classname[j]);
                S.append(",");
            }
            editForm.setClasscontent(S.toString());
        } else editForm.setClasscontent("");
        String scene;
        if(!editForm.getScenelist().equals(null)){
            scene = editForm.getScenelist().toString();
        }else
            scene="[]";
        if (!scene.equals("[]")) {
            scene = scene.replaceAll("\\[", "");
            scene = scene.replaceAll("\\]", "");
            String[] SS = scene.split(",");
            int[] SSI = new int[SS.length];
            String[] scenename = new String[SS.length];
            StringBuffer S = new StringBuffer();
            for (int i = 0; i < SS.length; i++) {
                SSI[i] = Integer.parseInt(SS[i]);
            }
            for (int j = 0; j < SSI.length; j++) {
                scenename[j] = SceneService.querySceneById(SSI[j]).getScene_name();
                S.append(scenename[j]);
                S.append(",");
            }
            editForm.setScenecontent(S.toString());
        } else editForm.setScenecontent("");

        String tag ;
        if(!editForm.getTaglist().equals(null)){
            System.out.println("segsd");
            tag = editForm.getTaglist().toString();
        }
        else tag = "[]";
        if (!tag.equals("[]")) {
            tag = tag.replaceAll("\\[", "");
            tag = tag.replaceAll("\\]", "");
            String[] TS = tag.split(",");
            int[] TSI = new int[TS.length];
            String[] tagname = new String[TS.length];
            StringBuffer S = new StringBuffer();
            for (int i = 0; i < TS.length; i++) {
                TSI[i] = Integer.parseInt(TS[i]);
            }
            for (int j = 0; j < TSI.length; j++) {
                tagname[j] = TagService.queryTagById(TSI[j]).getTag_name();
                S.append(tagname[j]);
                S.append(",");
            }
            editForm.setTagcontent(S.toString());
        } else editForm.setTagcontent("");
        System.out.println(editForm);
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        FrameAudit frameAudit = new FrameAudit();
        frameAudit.setFrame_id(editForm.getId());
        frameAudit.setDataset_id(editForm.getDataset_id());
        frameAudit.setCreate_person(editForm.getCreate_person());
        frameAudit.setCreate_time(editForm.getCreate_time());
        frameAudit.setPath(editForm.getPath());
        frameAudit.setTarget_id(editForm.getTarget_id());
        frameAudit.setType("删除帧");
        frameAudit.setClasscontent(editForm.getClasscontent());
        frameAudit.setScenecontent(editForm.getScenecontent());
        frameAudit.setTagcontent(editForm.getTagcontent());
        frameAudit.setStatus("未审核");
        frameAudit.setUpdate_person(editForm.getUpdate_person());
        frameAudit.setUpdate_time(now);
        frameAudit.setScenelist(editForm.getScenelist());
        frameAudit.setClasslist(editForm.getClasslist());
        frameAudit.setTaglist(editForm.getTaglist());
        FrameAuditService.addFrameAudit(frameAudit);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","删除帧申请提交成功");
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

    @RequestMapping(value = "/denyframe" ,produces = "text/html;charset=utf-8", method =RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String denyFrameAudit(int id,String tokenStr1){
        DenyForm denyForm = new DenyForm();
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        denyForm.setId(id);
        denyForm.setAuditor(tokenStr1);
        denyForm.setAudit_time(now);
        denyForm.setStatus("已驳回");
        FrameAuditService.Deny(denyForm);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("meta",meta);
        meta.put("msg","驳回成功");
        meta.put("status","200");
        return JSONObject.toJSONString(resultMap);
    }
}

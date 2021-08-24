package com.kaung.pogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrameAudit {
    private int id;
    private int frame_id;
    private int dataset_id;
    private String create_person;
    private String create_time;
    private String path;
    private String target_id;
    private String auditor;
    private String audit_time;
    private String type;
    private String classcontent;
    private String scenecontent;
    private String tagcontent;
    private String status;
    private String classlist;
    private String scenelist;
    private String taglist;
    private String update_person;
    private String update_time;

    public String getUpdate_person() {
        return update_person;
    }

    public void setUpdate_person(String update_person) {
        this.update_person = update_person;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getClasslist() {
        return classlist;
    }

    public String getTaglist() {
        return taglist;
    }

    public void setTaglist(String taglist) {
        this.taglist = taglist;
    }

    public void setClasslist(String classlist) {
        this.classlist = classlist;
    }

    public String getScenelist() {
        return scenelist;
    }

    public void setScenelist(String scenelist) {
        this.scenelist = scenelist;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagcontent() {
        return tagcontent;
    }

    public void setTagcontent(String tagcontent) {
        this.tagcontent = tagcontent;
    }

    public String getClasscontent() {
        return classcontent;
    }

    public void setClasscontent(String classcontent) {
        this.classcontent = classcontent;
    }

    public String getScenecontent() {
        return scenecontent;
    }

    public void setScenecontent(String scenecontent) {
        this.scenecontent = scenecontent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrame_id() {
        return frame_id;
    }

    public void setFrame_id(int frame_id) {
        this.frame_id = frame_id;
    }

    public int getDataset_id() {
        return dataset_id;
    }

    public void setDataset_id(int dataset_id) {
        this.dataset_id = dataset_id;
    }

    public String getCreate_person() {
        return create_person;
    }

    public void setCreate_person(String create_person) {
        this.create_person = create_person;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTarget_id() {
        return target_id;
    }

    public void setTarget_id(String target_id) {
        this.target_id = target_id;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAudit_time() {
        return audit_time;
    }

    public void setAudit_time(String audit_time) {
        this.audit_time = audit_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

package com.kaung.vo;

import java.util.Arrays;

public class FrameAddForm {
    private int datasetid;
    private int[] classcification;
    private int[] scene;
    private int[] tag;
    private String create_person;
    private String create_time;
    private String path;
    private String target;

    public FrameAddForm() {
    }

    public FrameAddForm(int datasetid, int[] classcification, int[] scene, int[] tag, String create_person, String create_time, String path, String target) {
        this.datasetid = datasetid;
        this.classcification = classcification;
        this.scene = scene;
        this.tag = tag;
        this.create_person = create_person;
        this.create_time = create_time;
        this.path = path;
        this.target = target;
    }

    public int getDatasetid() {
        return datasetid;
    }

    public void setDatasetid(int datasetid) {
        this.datasetid = datasetid;
    }

    public int[] getClasscification() {
        return classcification;
    }

    public void setClasscification(int[] classcification) {
        this.classcification = classcification;
    }

    public int[] getScene() {
        return scene;
    }

    public void setScene(int[] scene) {
        this.scene = scene;
    }

    public int[] getTag() {
        return tag;
    }

    public void setTag(int[] tag) {
        this.tag = tag;
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "FrameAddForm{" +
                "datasetid=" + datasetid +
                ", classcification=" + Arrays.toString(classcification) +
                ", scene=" + Arrays.toString(scene) +
                ", tag=" + Arrays.toString(tag) +
                ", create_person='" + create_person + '\'' +
                ", create_time='" + create_time + '\'' +
                ", path='" + path + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}

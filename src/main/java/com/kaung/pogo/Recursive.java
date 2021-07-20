package com.kaung.pogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recursive {
    private int id;
    private String record_path;
    private int class_refer;
    private int scene_refer;
    private String user;
    private String use_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecord_path() {
        return record_path;
    }

    public void setRecord_path(String record_path) {
        this.record_path = record_path;
    }

    public int getClass_refer() {
        return class_refer;
    }

    public void setClass_refer(int class_refer) {
        this.class_refer = class_refer;
    }

    public int getScene_refer() {
        return scene_refer;
    }

    public void setScene_refer(int scene_refer) {
        this.scene_refer = scene_refer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUse_time() {
        return use_time;
    }

    public void setUse_time(String use_time) {
        this.use_time = use_time;
    }
}

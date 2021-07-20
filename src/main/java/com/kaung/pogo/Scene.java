package com.kaung.pogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scene {
    private int id;
    private String scene_name;
    private String remarks;
    private String create_person;
    private String create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScene_name() {
        return scene_name;
    }

    public void setScene_name(String scene_name) {
        this.scene_name = scene_name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
}

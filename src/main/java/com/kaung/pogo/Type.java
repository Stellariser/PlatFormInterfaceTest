package com.kaung.pogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private int id;
    private int cam_id;
    private int type;
    private int effective_frames;
    private String create_person;
    private String create_time;
    private String update_person;
    private String update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCam_id() {
        return cam_id;
    }

    public void setCam_id(int cam_id) {
        this.cam_id = cam_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getEffective_frames() {
        return effective_frames;
    }

    public void setEffective_frames(int effective_frames) {
        this.effective_frames = effective_frames;
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
}

package com.kaung.pogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrameToScene {
    private int id;
    private int frame_id;
    private int scene_id_id;

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

    public int getScene_id_id() {
        return scene_id_id;
    }

    public void setScene_id_id(int scene_id_id) {
        this.scene_id_id = scene_id_id;
    }
}

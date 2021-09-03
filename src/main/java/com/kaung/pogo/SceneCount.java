package com.kaung.pogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SceneCount {
    private String scene_name;
    private int scene_count;

    public String getScene_name() {
        return scene_name;
    }

    public void setScene_name(String scene_name) {
        this.scene_name = scene_name;
    }

    public int getScene_count() {
        return scene_count;
    }

    public void setScene_count(int scene_count) {
        this.scene_count = scene_count;
    }
}

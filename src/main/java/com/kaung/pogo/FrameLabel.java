package com.kaung.pogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrameLabel {
    private int id;
    private int frame_id;
    private int left_point_x;
    private int left_point_y;
    private int right_point_x;
    private int right_point_y;
    private int centre_point_x;
    private int centre_point_y;
    private int width;
    private int height;

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

    public int getLeft_point_x() {
        return left_point_x;
    }

    public void setLeft_point_x(int left_point_x) {
        this.left_point_x = left_point_x;
    }

    public int getLeft_point_y() {
        return left_point_y;
    }

    public void setLeft_point_y(int left_point_y) {
        this.left_point_y = left_point_y;
    }

    public int getRight_point_x() {
        return right_point_x;
    }

    public void setRight_point_x(int right_point_x) {
        this.right_point_x = right_point_x;
    }

    public int getRight_point_y() {
        return right_point_y;
    }

    public void setRight_point_y(int right_point_y) {
        this.right_point_y = right_point_y;
    }

    public int getCentre_point_x() {
        return centre_point_x;
    }

    public void setCentre_point_x(int centre_point_x) {
        this.centre_point_x = centre_point_x;
    }

    public int getCentre_point_y() {
        return centre_point_y;
    }

    public void setCentre_point_y(int centre_point_y) {
        this.centre_point_y = centre_point_y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

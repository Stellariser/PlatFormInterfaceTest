package com.kaung.pogo;

public class LabelQueryInfo {
    private int pageSize;
    private int pageNumber;
    private int frame_id;

    public LabelQueryInfo() {
    }

    public LabelQueryInfo(int pageSize, int pageNumber, int frame_id) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.frame_id = frame_id;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getFrame_id() {
        return frame_id;
    }

    public void setFrame_id(int frame_id) {
        this.frame_id = frame_id;
    }
}

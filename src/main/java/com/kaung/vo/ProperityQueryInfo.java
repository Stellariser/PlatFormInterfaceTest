package com.kaung.vo;

import java.util.List;

public class ProperityQueryInfo {
    private int[] sceneList;
    private int[] classcificationList;
    private int[] datasetList;
    private String query;
    private int pageSize;
    private int pageNumber;

    public ProperityQueryInfo() {
    }

    public ProperityQueryInfo(int[] sceneList, int[] classcificationList, int[] datasetList, String query, int pageSize, int pageNumber) {
        this.sceneList = sceneList;
        this.classcificationList = classcificationList;
        this.datasetList = datasetList;
        this.query = query;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public int[] getSceneList() {
        return sceneList;
    }

    public void setSceneList(int[] sceneList) {
        this.sceneList = sceneList;
    }

    public int[] getClasscificationList() {
        return classcificationList;
    }

    public void setClasscificationList(int[] classcificationList) {
        this.classcificationList = classcificationList;
    }

    public int[] getDatasetList() {
        return datasetList;
    }

    public void setDatasetList(int[] datasetList) {
        this.datasetList = datasetList;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
}

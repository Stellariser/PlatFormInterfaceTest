package com.kaung.vo;

import java.util.List;

public class ProperityQueryInfo {
    private int[] sceneList;
    private int[] classcificationList;
    private int[] datasetList;
    private int[] nosceneList;
    private int[] noclasscificationList;
    private int[] nodatasetList;
    private String query;
    private int pageSize;
    private int pageNumber;
    private String extendLabel;

    public ProperityQueryInfo() {
    }

    public ProperityQueryInfo(int[] sceneList, int[] classcificationList, int[] datasetList, int[] nosceneList, int[] noclasscificationList, int[] nodatasetList, String query, int pageSize, int pageNumber, String extendLabel) {
        this.sceneList = sceneList;
        this.classcificationList = classcificationList;
        this.datasetList = datasetList;
        this.nosceneList = nosceneList;
        this.noclasscificationList = noclasscificationList;
        this.nodatasetList = nodatasetList;
        this.query = query;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.extendLabel = extendLabel;
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

    public int[] getNosceneList() {
        return nosceneList;
    }

    public void setNosceneList(int[] nosceneList) {
        this.nosceneList = nosceneList;
    }

    public int[] getNoclasscificationList() {
        return noclasscificationList;
    }

    public void setNoclasscificationList(int[] noclasscificationList) {
        this.noclasscificationList = noclasscificationList;
    }

    public int[] getNodatasetList() {
        return nodatasetList;
    }

    public void setNodatasetList(int[] nodatasetList) {
        this.nodatasetList = nodatasetList;
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

    public String getExtendLabel() {
        return extendLabel;
    }

    public void setExtendLabel(String extendLabel) {
        this.extendLabel = extendLabel;
    }
}

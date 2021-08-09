package com.kaung.pogo;

public class QueryInfo {
    private String query;
    private int pageSize;
    private int pageNumber;
    private int[] sceneList;
    private int[] classcificationList;

    public QueryInfo(String query, int pageSize, int pageNumber, int[] sceneList, int[] classcificationList) {
        this.query = query;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.sceneList = sceneList;
        this.classcificationList = classcificationList;
    }

    public QueryInfo() {
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
}

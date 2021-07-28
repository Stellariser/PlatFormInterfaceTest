package com.kaung.pogo;

public class QueryInfo {
    private String query;
    private int pageSize;
    private int pageNumber;

    public QueryInfo() {
    }

    public QueryInfo(int pageSize, int pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public QueryInfo(String query, int pageSize, int pageNumber) {
        this.query = query;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
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

package com.kaung.pogo;

import java.util.List;

public class PageBean<T> {

    private int pc; //当前页码
    //  private int tp; //总页数
    private int tr; //总记录数
    private int ps; //每页记录数
    private List<T> beanList; //当前页记录
    private int s;  //每页开始的记录数
    private T custom;//扩展类



    public T getCustom() {
        return custom;
    }

    public void setCustom(T custom) {
        this.custom = custom;
    }

    private String url;

    public int getS() {
        return (pc-1)*ps;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getPc() {
        return pc;
    }
    public void setPc(int pc) {
        this.pc = pc;
    }
    public int getTp() {
        int tp = tr/ps;
        return tr%ps==0 ? tp : tp+1;
    }
    //  public void setTp(int tp) {
//      this.tp = tp;
//  }
    public int getTr() {
        return tr;
    }
    public void setTr(int tr) {
        this.tr = tr;
    }
    public int getPs() {
        return ps;
    }
    public void setPs(int ps) {
        this.ps = ps;
    }
    public List<T> getBeanList() {
        return beanList;
    }
    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }


}

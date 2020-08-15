package com.czxy.domain;


public class ShopPage {
    private Integer pageNum;
    private Integer pageSize;
    private Integer status;

    @Override
    public String toString() {
        return "ShopPage{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", status=" + status +
                '}';
    }

    public ShopPage() {
    }

    public ShopPage(Integer pageNum, Integer pageSize, Integer status) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.status = status;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

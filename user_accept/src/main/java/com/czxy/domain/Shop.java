package com.czxy.domain;


import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_shop")
public class Shop {
    @Id
    private Integer id;
    private String shopname;
    private Double shopprice;
    private Double lufei;
    private Integer uid;
    private Integer oid;
    private Order order;
    private Integer status;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shopname='" + shopname + '\'' +
                ", shopprice=" + shopprice +
                ", lufei=" + lufei +
                ", uid=" + uid +
                ", oid=" + oid +
                ", status=" + status +
                '}';
    }

    public Shop() {
    }

    public Shop(Integer id, String shopname, Double shopprice, Double lufei, Integer uid, Integer oid, Integer status) {
        this.id = id;
        this.shopname = shopname;
        this.shopprice = shopprice;
        this.lufei = lufei;
        this.uid = uid;
        this.oid = oid;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public Double getShopprice() {
        return shopprice;
    }

    public void setShopprice(Double shopprice) {
        this.shopprice = shopprice;
    }

    public Double getLufei() {
        return lufei;
    }

    public void setLufei(Double lufei) {
        this.lufei = lufei;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_order")
public class Order {
    @Id
    private Integer oid;
    private String oname;

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", oname='" + oname + '\'' +
                '}';
    }

    public Order() {
    }

    public Order(Integer oid, String oname) {
        this.oid = oid;
        this.oname = oname;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }
}

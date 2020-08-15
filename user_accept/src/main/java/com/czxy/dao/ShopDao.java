package com.czxy.dao;


import com.czxy.domain.Shop;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ShopDao extends Mapper<Shop> {
    @Select("select * from t_shop where status =0")
    @Results({
            @Result(property = "oid",column = "oid"),
            @Result(property = "order",column = "oid",one = @One(select = "com.czxy.dao.OrderDao.selectByPrimaryKey")),
    })
    List<Shop> selectAll1();
    @Select("select * from t_shop where status =#{uid} ")
    @Results({
            @Result(property = "oid",column = "oid"),
            @Result(property = "order",column = "oid",one = @One(select = "com.czxy.dao.OrderDao.selectByPrimaryKey")),
    })
    List<Shop> selectByUid(Integer uid);
}

package com.czxy.service;


import com.czxy.domain.Shop;
import com.czxy.domain.ShopPage;
import com.github.pagehelper.PageInfo;

public interface ShopService {
    PageInfo<Shop> fandAllByPage(ShopPage shopPage);

    void release(Shop shop);


    void join(Shop shop, Integer uids);


    PageInfo<Shop> selectByUid(Integer uid, ShopPage shopPage);
}

package com.czxy.service.impl;


import com.czxy.dao.ShopDao;
import com.czxy.domain.Shop;
import com.czxy.domain.ShopPage;
import com.czxy.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopDao shopDao;
    @Override
    public PageInfo<Shop> fandAllByPage(ShopPage shopPage) {

        PageHelper.startPage(shopPage.getPageNum(),shopPage.getPageSize());
        List<Shop> shops = shopDao.selectAll1();
        return new PageInfo<Shop>(shops);
    }

    @Override
    public void release(Shop shop) {
        shopDao.insert(shop);
    }

    @Override
    public void join(Shop shop, Integer uids) {
        shop.setStatus(uids);
        shopDao.updateByPrimaryKeySelective(shop);
    }

    @Override
    public PageInfo<Shop> selectByUid(Integer uid, ShopPage shopPage) {
        PageHelper.startPage(shopPage.getPageNum(),shopPage.getPageSize());
        List<Shop> shops = shopDao.selectByUid(uid);
        return new PageInfo<Shop>(shops);
    }


}

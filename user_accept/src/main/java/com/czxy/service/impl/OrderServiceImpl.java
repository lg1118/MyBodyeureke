package com.czxy.service.impl;


import com.czxy.dao.OrderDao;
import com.czxy.domain.Order;
import com.czxy.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Override
    public List<Order> fandOrder() {
        return orderDao.selectAll();
    }
}

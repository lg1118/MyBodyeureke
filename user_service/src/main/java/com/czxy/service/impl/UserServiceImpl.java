package com.czxy.service.impl;


import com.czxy.dao.UserDao;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public Boolean registered(User user) {
        try {
            userDao.insert(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public User login(User user) {
        Example example = new Example(User.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("username",user.getUsername());
        c.andEqualTo("password",user.getPassword());
        User user1 = userDao.selectOneByExample(example);
        return user1;
    }
}

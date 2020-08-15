package com.czxy.service;


import com.czxy.domain.User;

public interface UserService {
    Boolean registered(User user);

    User login(User user);
}

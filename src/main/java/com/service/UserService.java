package com.service;

import com.entity.User;

import java.util.List;


/**
 * Created by 123 on 2017/11/16.
 */
public interface UserService {

    User getUserById(Integer id);
    void updateUserMoney(Integer userId, Integer addMoney);
}


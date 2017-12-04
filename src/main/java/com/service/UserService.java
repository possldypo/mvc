package com.service;

import com.entity.TUser;
import com.entity.User;

import java.util.List;


public interface UserService {

    User getUserById(Integer id);
    void updateUserMoney(Integer userId, Integer addMoney);
    void insertTUser(TUser user);
    TUser selectTUser(String eMail);
}


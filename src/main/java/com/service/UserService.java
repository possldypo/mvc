package com.service;

import com.entity.TRetrievedPassword;
import com.entity.TUser;
import com.entity.User;


public interface UserService {

    User getUserById(Integer id);
    void updateUserMoney(Integer userId, Integer addMoney);
    void insertTUser(TUser user);
    TUser selectTUser(String eMail);
    void insertRetrieved(String email,String password);
    TRetrievedPassword selectRPByEmail(String email);
    void updatePassword(String email,Integer id,String password);
}


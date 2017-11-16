package com.service;

import com.entity.User;

import java.util.List;


/**
 * Created by 123 on 2017/11/16.
 */
public interface UserService {

    List<User> getUserById(Integer id);
}

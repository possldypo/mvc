package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 123 on 2017/11/15.
 */
@Repository
public interface UserDao {
    List<User> getUser(@Param("id")Integer id);
}

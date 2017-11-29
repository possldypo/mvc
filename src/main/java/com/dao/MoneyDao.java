package com.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 黎 on 2017/11/16.
 */
@Repository
public interface MoneyDao {
    Integer getUserMoney(@Param("userId") Integer userId);

    void updateUserMoney(@Param("userId") Integer userId,@Param("money")Integer money);

    void insertUserMoney(@Param("userId")Integer userId,@Param("money")Integer money);
}

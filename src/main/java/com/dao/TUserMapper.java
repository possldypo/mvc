package com.dao;

import com.entity.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser selectByEmail(String eMail);

    int updatePasswordByEmail(@Param("password") String password, @Param("email") String email);

    int updatePasswordById(@Param("password") String password,@Param("id") Integer id);
}
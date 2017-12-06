package com.dao;

import com.entity.TRetrievedPassword;
import org.springframework.stereotype.Repository;

@Repository
public interface TRetrievedPasswordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRetrievedPassword record);

    int insertSelective(TRetrievedPassword record);

    TRetrievedPassword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRetrievedPassword record);

    int updateByPrimaryKey(TRetrievedPassword record);

    TRetrievedPassword selectByEmail(String email);
}
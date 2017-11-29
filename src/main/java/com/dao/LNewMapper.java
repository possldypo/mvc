package com.dao;

import com.entity.LNew;

public interface LNewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LNew record);

    int insertSelective(LNew record);

    LNew selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LNew record);

    int updateByPrimaryKeyWithBLOBs(LNew record);

    int updateByPrimaryKey(LNew record);
}
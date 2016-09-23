package com.xzh.comb.mapper;

import com.xzh.comb.model.Clients;

public interface ClientsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clients record);

    int insertSelective(Clients record);

    Clients selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clients record);

    int updateByPrimaryKey(Clients record);
}
package com.xzh.comb.mapper;

import java.util.List;
import java.util.Map;

import com.xzh.comb.model.Sessions;

public interface SessionsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sessions record);

    int insertSelective(Sessions record);

    Sessions selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sessions record);

    int updateByPrimaryKey(Sessions record);

	List<Sessions> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);
}
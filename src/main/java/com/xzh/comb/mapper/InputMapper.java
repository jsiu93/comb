package com.xzh.comb.mapper;

import java.util.List;
import java.util.Map;

import com.xzh.comb.model.Input;

public interface InputMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Input record);

    int insertSelective(Input record);

    Input selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Input record);

    int updateByPrimaryKeyWithBLOBs(Input record);

    int updateByPrimaryKey(Input record);

	List<Input> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);
}
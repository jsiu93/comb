package com.xzh.comb.mapper;

import java.util.List;
import java.util.Map;

import com.xzh.comb.model.LoginInfo;

public interface LoginInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginInfo record);

    int insertSelective(LoginInfo record);

    LoginInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginInfo record);

    int updateByPrimaryKey(LoginInfo record);

	List<LoginInfo> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);
}
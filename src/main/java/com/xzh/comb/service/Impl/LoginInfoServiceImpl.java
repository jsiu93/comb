package com.xzh.comb.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzh.comb.mapper.LoginInfoMapper;
import com.xzh.comb.model.LoginInfo;
import com.xzh.comb.service.LoginInfoService;

@Service
public class LoginInfoServiceImpl implements LoginInfoService{

	@Autowired
	private LoginInfoMapper loginInfoMapper;

	public List<LoginInfo> list(Map<String, Object> map) {
		return loginInfoMapper.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return loginInfoMapper.getTotal(map);
	}
}

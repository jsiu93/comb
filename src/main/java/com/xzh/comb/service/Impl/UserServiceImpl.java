package com.xzh.comb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzh.comb.mapper.UserMapper;
import com.xzh.comb.model.User;
import com.xzh.comb.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public User getByAccount(String account) {
		return userMapper.getByAccount(account);
	}

}

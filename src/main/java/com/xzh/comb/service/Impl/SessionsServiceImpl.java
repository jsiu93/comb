package com.xzh.comb.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzh.comb.mapper.SessionsMapper;
import com.xzh.comb.model.Sessions;
import com.xzh.comb.service.SessionsService;

@Service
public class SessionsServiceImpl implements SessionsService{

	@Autowired
	private SessionsMapper sessionsMapper;
	
	public List<Sessions> list(Map<String, Object> map) {
		return sessionsMapper.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return sessionsMapper.getTotal(map);
	}

}

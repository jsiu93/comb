package com.xzh.comb.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzh.comb.mapper.InputMapper;
import com.xzh.comb.model.Input;
import com.xzh.comb.service.InputService;

@Service
public class InputServiceImpl implements InputService{

	@Autowired
	private InputMapper inputMapper;

	public List<Input> list(Map<String, Object> map) {
		return inputMapper.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return inputMapper.getTotal(map);
	}
}

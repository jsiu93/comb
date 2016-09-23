package com.xzh.comb.service;

import java.util.List;
import java.util.Map;

import com.xzh.comb.model.Input;

public interface InputService {

	List<Input> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);

}

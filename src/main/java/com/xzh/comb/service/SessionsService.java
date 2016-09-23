package com.xzh.comb.service;

import java.util.List;
import java.util.Map;

import com.xzh.comb.model.Sessions;

public interface SessionsService {

	List<Sessions> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);

}

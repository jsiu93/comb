package com.xzh.comb.service;

import java.util.List;
import java.util.Map;

import com.xzh.comb.model.LoginInfo;

public interface LoginInfoService {

	List<LoginInfo> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);

}

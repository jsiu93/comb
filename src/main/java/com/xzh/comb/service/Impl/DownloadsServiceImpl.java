package com.xzh.comb.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzh.comb.mapper.DownloadsMapper;
import com.xzh.comb.model.Downloads;
import com.xzh.comb.service.DownloadsService;

@Service
public class DownloadsServiceImpl implements DownloadsService{

	@Autowired
	private DownloadsMapper downloadsMapper;

	public List<Downloads> list(Map<String, Object> map) {
		return downloadsMapper.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return downloadsMapper.getTotal(map);
	}
}

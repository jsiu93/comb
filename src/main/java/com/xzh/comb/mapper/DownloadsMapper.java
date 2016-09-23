package com.xzh.comb.mapper;

import java.util.List;
import java.util.Map;

import com.xzh.comb.model.Downloads;

public interface DownloadsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Downloads record);

    int insertSelective(Downloads record);

    Downloads selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Downloads record);

    int updateByPrimaryKeyWithBLOBs(Downloads record);

    int updateByPrimaryKey(Downloads record);

	List<Downloads> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);
}
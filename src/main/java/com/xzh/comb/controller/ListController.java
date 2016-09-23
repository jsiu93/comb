package com.xzh.comb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Maps;
import com.xzh.comb.utils.DateJsonValueProcessor;
import com.xzh.comb.model.Downloads;
import com.xzh.comb.model.Input;
import com.xzh.comb.model.LoginInfo;
import com.xzh.comb.model.Sessions;
import com.xzh.comb.service.DownloadsService;
import com.xzh.comb.service.InputService;
import com.xzh.comb.service.LoginInfoService;
import com.xzh.comb.service.SessionsService;
import com.xzh.comb.utils.PageBean;
import com.xzh.comb.utils.ResponseUtil;
import com.xzh.comb.utils.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/list")
public class ListController {

	private static Logger logger = LoggerFactory.getLogger(ListController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
	}

	@Autowired
	private LoginInfoService loginInfoService;
	
	@Autowired
	private SessionsService sessionsService;
	
	@Autowired
	private InputService inputService;
	
	@Autowired
	private DownloadsService downloadsService;

	@RequestMapping("/loginInfoList")
	public String loginInfoList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, LoginInfo s_loginInfo, String startTime,
			String endTime, String sort, String order, HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = Maps.newHashMap();
		map.put("session", StringUtil.formatLike(s_loginInfo.getSession()));
		map.put("username", StringUtil.formatLike(s_loginInfo.getUsername()));
		map.put("password", StringUtil.formatLike(s_loginInfo.getPassword()));
		map.put("success", s_loginInfo.getSuccess());
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		if (StringUtils.isNoneBlank(sort)) {
			map.put("sort", sort);
			map.put("order", order);
		}

		List<LoginInfo> list = loginInfoService.list(map);
		Long total = loginInfoService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);

		ResponseUtil.write(response, result);

		return null;
	}

	@RequestMapping("/sessionsInfoList")
	public String sessionsInfoList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, Sessions s_session, String sort, String order, String startTime,
			String endTime, HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = Maps.newHashMap();
		map.put("id", StringUtil.formatLike(s_session.getId()));
		map.put("ip", StringUtil.formatLike(s_session.getIp()));
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		if (StringUtils.isNoneBlank(sort)) {
			map.put("sort", sort);
			map.put("order", order);
		}
		
		List<Sessions> list = sessionsService.list(map);
		Long total = sessionsService.getTotal(map);
		
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);

		ResponseUtil.write(response, result);

		return null;
	}
	
	@RequestMapping("/inputInfoList")
	public String inputInfoList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, String sort, String order, String startTime,
			String endTime, Input s_input, HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = Maps.newHashMap();
		map.put("session", StringUtil.formatLike(s_input.getSession()));
		map.put("ip", StringUtil.formatLike(s_input.getIp()));
		map.put("success", s_input.getSuccess());
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		if (StringUtils.isNoneBlank(sort)) {
			map.put("sort", sort);
			map.put("order", order);
		}
		List<Input> list = inputService.list(map);
		Long total = inputService.getTotal(map);
		
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);

		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/downloadsInfoList")
	public String downloadsInfoList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = Maps.newHashMap();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		
		List<Downloads> list = downloadsService.list(map);
		Long total = downloadsService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		
		ResponseUtil.write(response, result);
		return null;
	}
}

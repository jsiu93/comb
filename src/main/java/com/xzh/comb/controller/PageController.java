package com.xzh.comb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于跳转
 * @author JSiu
 *
 */
@Controller
@RequestMapping("/page")
public class PageController {
	
	@RequestMapping("/loginInfoPage")
	public String loginInfoPage(){
		return "/admin/loginInfoPage";
	}
	
	@RequestMapping("/sessionsInfoPage")
	public String sessionsInfoPage(){
		return "/admin/sessionsInfoPage";
	}
	
	@RequestMapping("/inputInfoPage")
	public String inputInfoPage(){
		return "/admin/inputInfoPage";
	}
	
	@RequestMapping("/downloadsInfoPage")
	public String downloadsInfoPage(){
		return "/admin/downloadsInfoPage";
	}
	
}

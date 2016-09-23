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
	
}

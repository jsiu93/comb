package com.xzh.comb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xzh.comb.model.User;
import com.xzh.comb.utils.CryptographyUtil;
import com.xzh.comb.utils.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/")
	public String index(){
		return "redirect:/index";
	}
	
	@RequestMapping(value="/index")
	public String index(Model model){
		return "index";
	} 

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model, HttpServletRequest request){
		logger.info("GET 请求登录");
		if(SecurityUtils.getSubject().isAuthenticated()){
			return "redirect:/index";
		}
		return "/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginPost(User user, HttpServletRequest request, HttpServletResponse response) throws ConfigurationException{
		logger.info("post请求登录");
		JSONObject result = new JSONObject();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), CryptographyUtil.md5(user.getPassword(), new PropertiesConfiguration("systemConfig.properties").getString("salt")));
		try {
			subject.login(token);
			result.put("success", true);
			ResponseUtil.write(response, result);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorInfo", "用户名或密码错误");
			return "login";
		}
		
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject result = new JSONObject();
		logger.info("登出");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}

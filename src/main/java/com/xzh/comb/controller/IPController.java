package com.xzh.comb.controller;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xzh.comb.utils.ResponseUtil;


@Controller
public class IPController {
	
	private static String getPath(){
		try {
			String path = new PropertiesConfiguration("systemConfig.properties").getString("IP_Api");
			return path;
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/ip/getAddress")
	public String getJsonFromIp(String ip, HttpServletResponse res){
		try {
			JSONObject result = new JSONObject();
			String url = getPath() + ip;
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			RequestConfig requestConfig = RequestConfig.custom()  
			        .setConnectTimeout(5000).setConnectionRequestTimeout(1000)  
			        .setSocketTimeout(5000).build();  
			httpGet.setConfig(requestConfig); 
			CloseableHttpResponse response = httpClient.execute(httpGet);  
			HttpEntity entity = response.getEntity();//得到请求回来的数据
			
			JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(entity));
			Integer code = Integer.parseInt(jsonObject.getString("code"));
			if(code != 0){
				result.put("success", false);
				ResponseUtil.write(res, result);
				return null;
			} else {
				result.put("data", jsonObject.get("data"));
				result.put("success", true);
				ResponseUtil.write(res, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

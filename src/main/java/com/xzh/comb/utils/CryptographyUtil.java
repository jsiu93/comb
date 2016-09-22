package com.xzh.comb.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {

	/**
	 * md5 加密 带盐
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str, String salt){
		return new Md5Hash(str, salt).toString();
	}
	
//	public static void main(String[] args) throws ConfigurationException {
//		String password="iPhone7s";
//		String salt = new PropertiesConfiguration("systemConfig.properties").getString("salt");
//		System.out.println("md5: " + CryptographyUtil.md5(password, salt));
//		
//	}
}

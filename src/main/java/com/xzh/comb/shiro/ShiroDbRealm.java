package com.xzh.comb.shiro;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.xzh.comb.model.User;
import com.xzh.comb.service.UserService;

public class ShiroDbRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String account = (String) token.getPrincipal();
		User user = userService.getByAccount(account);
		if(user != null){
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), "xxx");
			return authenticationInfo;
		} else {
			return null;
		}
	}

}

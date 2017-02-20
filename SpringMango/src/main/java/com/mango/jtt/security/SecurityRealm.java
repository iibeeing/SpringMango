package com.mango.jtt.security;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import com.mango.jtt.dao.IUserTDao;
import com.mango.jtt.model.UserT;

public class SecurityRealm extends AuthorizingRealm {
	private static Logger logger = Logger.getLogger(SecurityRealm.class);

	@Autowired
	private IUserTDao userTDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = String.valueOf(principals.getPrimaryPrincipal());
		System.out.println("doGetAuthorizationInfo username : " + username);

		// 添加角色...

		// 添加权限...

		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = String.valueOf(token.getPrincipal());
		String password = new String((char[]) token.getCredentials());
		UserT unauthUser = new UserT();
		unauthUser.setUserName(username);
		unauthUser.setPassword(password);
		List<UserT> list;
		try {
			list = userTDao.select(unauthUser);
			if (list != null && list.size() == 1) {
				UserT authUser = list.get(0);
			} else {
				throw new AuthenticationException("用户名或密码错误.");
			}
		} catch (Exception e) {
			if (e instanceof AuthenticationException) {
				throw new AuthenticationException("用户名或密码错误.");
			}
			e.printStackTrace();
		}

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				username, password, getName());
		return authenticationInfo;
	}

}

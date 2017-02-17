package com.mango.jtt.security;

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

import com.mango.jtt.model.UserT;
import com.mango.jtt.service.IUserTService;

/**
 * @ClassName: SecurityRealm
 * @Description: 用户身份验证,授权 Realm 组件
 * @author BEE
 * @date 2017-2-16 下午4:31:45
 */
//@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {
	private static Logger logger = Logger.getLogger(SecurityRealm.class);

	@Autowired
	private IUserTService userTService;

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
		// 通过数据库进行验证
		UserT unauthUser = new UserT();
		unauthUser.userName = username;
		unauthUser.password = password;
		try {
			final UserT authUser = userTService.authenticate(unauthUser);
			logger.info("待验证用户：" + unauthUser);
			logger.info("验证结果:" + authUser);
			if (authUser == null) {
				throw new AuthenticationException("用户名或密码错误.");
			}
		} catch (Exception e) {
		}

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				username, password, getName());

		return authenticationInfo;
	}

}

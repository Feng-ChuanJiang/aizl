package org.lemonPig.os.assist.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.lemonPig.os.core.constants.UserStatus;
import org.lemonPig.os.core.iservice.IUserService;
import org.lemonPig.os.core.vo.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	private IUserService iUserService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(user.getRoleENames());
		authorizationInfo.setStringPermissions(user.getPermissionNames());
		return authorizationInfo;
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User user = iUserService.findLoginUserByUserName(username);
		if (user == null || UserStatus.DISCARDED.equals(user.getStatus())) {
			throw new UnknownAccountException();// 没找到帐号
		}else if (UserStatus.LOCKED.equals(user.getStatus())) {
			throw new LockedAccountException(); // 帐号锁定
		}
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user, // 用户
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getSalt()),// salt=随机字符串
				getName() // realm name
		);
		return authenticationInfo;
	}
}

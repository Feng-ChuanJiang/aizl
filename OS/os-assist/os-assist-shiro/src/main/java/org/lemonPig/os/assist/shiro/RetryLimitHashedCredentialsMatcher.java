package org.lemonPig.os.assist.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class RetryLimitHashedCredentialsMatcher extends SimpleCredentialsMatcher {
	private SaltHashHelper saltHashHelper;
	private Cache passwordRetryCache;
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		// 按用户名缓存登录失败次数
		String username = (String) token.getPrincipal();
		// retry count + 1
		Element element = passwordRetryCache.get(username);
		if (element == null) {
			element = new Element(username, new AtomicInteger(0));
			passwordRetryCache.put(element);
		}
		AtomicInteger retryCount = (AtomicInteger) element.getObjectValue();
		if (retryCount.incrementAndGet() > 5) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException();
		}
		//token密码hash后匹配储存密码
		boolean matches =saltHashHelper.hashMache(token, info);
		if (matches) {
			// clear retry count
			passwordRetryCache.remove(username);
		}
		return matches;
	}
	public SaltHashHelper getSaltHashHelper() {
		return saltHashHelper;
	}
	public void setSaltHashHelper(SaltHashHelper saltHashHelper) {
		this.saltHashHelper = saltHashHelper;
	}
	public Cache getPasswordRetryCache() {
		return passwordRetryCache;
	}
	public void setPasswordRetryCache(Cache passwordRetryCache) {
		this.passwordRetryCache = passwordRetryCache;
	}


}

package org.lemonPig.os.assist.shiro;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{
    private static final Logger log = LoggerFactory.getLogger(CustomFormAuthenticationFilter.class);

	private String loginPage;
	/**
	 * 该方法主要提供给非登录请求权限验证失败后跳转使用
	 * 原代码逻辑需访问到Controller再由controller跳转，修改为直接跳转到login.jsp
	 */
	@Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		String loginPage=getLoginPage();
		Assert.hasText(loginPage);
        WebUtils.issueRedirect(request, response, loginPage);
    }
	

	@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                //修改为如果错误参数有值(验证码错误)就不在去登录验证
                String loginFailureAttribute=(String) request.getAttribute(getFailureKeyAttribute());
                if (StringUtils.hasText(loginFailureAttribute)) {
                	//直接跳到Controller
                	return true;
				}else {
					//执行登录后再跳到Controller
					return executeLogin(request, response);
				}
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                //allow them to see the login page ;)
                saveRequestAndRedirectToLogin(request, response);
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }

            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }
	/**
	 * 登录失败后解析异常为错误参数
	 */
	@Override
	protected void setFailureAttribute(ServletRequest request,
			AuthenticationException e) {
		String failureAttributeName = getFailureKeyAttribute();
		if (e instanceof IncorrectCredentialsException) {
			request.setAttribute(failureAttributeName, "密码错误");
		} else if (e instanceof UnknownAccountException) {
			request.setAttribute(failureAttributeName, "账号不存在");
		} else if (e instanceof LockedAccountException) {
			request.setAttribute(failureAttributeName, "账号被锁定");
		} else {
			request.setAttribute(failureAttributeName, "系统发生未知错误");
		}
	}
	

	public String getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

}

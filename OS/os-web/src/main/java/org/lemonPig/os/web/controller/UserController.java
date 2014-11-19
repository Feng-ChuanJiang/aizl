package org.lemonPig.os.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.lemonPig.os.common.Result;
import org.lemonPig.os.common.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 该controller只有登录失败后才会进入，主要是处理失败跳转和参数处理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
@SessionAttributes()
public class UserController {
	@Value(value = "${shiro.loginFailAttributeName}")
	private String loginFailAttributeName;
	@ResponseBody
	@RequestMapping("/login")
	public Result login(HttpServletRequest request) {
		Result result=null;
		//捕获登录错误
		String loginError=(String) request.getAttribute(loginFailAttributeName);
		if (StringUtils.isNotBlank(loginError)) {
			result=Result.buildErrorResult(loginError);
			return result;
		}
		//没有错误信息却进入该错误处理方法
		result=Result.buildErrorResult("未能识别的登录错误!");
		return result;
	}
}

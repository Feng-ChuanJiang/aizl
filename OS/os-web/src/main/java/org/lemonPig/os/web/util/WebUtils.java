package org.lemonPig.os.web.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.lemonPig.os.assist.spring.BizException;
import org.lemonPig.os.common.Constants;
import org.lemonPig.os.core.vo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class WebUtils {
	public static void forwardToUri(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,String uri) throws ServletException, IOException {
		httpServletRequest.getRequestDispatcher(uri).forward(httpServletRequest, httpServletResponse);
	}
	public static void handleBandingResult(BindingResult bindingResult) {
		if (bindingResult!=null&&bindingResult.hasErrors()) {
			List<FieldError> errors=bindingResult.getFieldErrors();
			StringBuffer messages=new StringBuffer();
			int i=0;
			for (FieldError fieldError : errors) {
				messages.append(fieldError.getDefaultMessage());
				if (i++!=errors.size()-1) {
					messages.append(",");
				}
			}
			throw new BizException(messages.toString());
		}
	}
	public static User getCurrentUser() {
		Subject subject=SecurityUtils.getSubject();
		return (User) subject.getSession().getAttribute("USER_IN_SESSION");
	}
}

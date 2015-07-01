package org.lemonPig.os.assist.spring;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;

public class HandlerMethodWrapper {
	HandlerMethod handlerMethod;
	public HandlerMethodWrapper(HandlerMethod handlerMethod){
		this.handlerMethod=handlerMethod;
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append(handlerMethod.getMethod().getReturnType().getName());
		sb.append(" ");
		sb.append(handlerMethod.getBeanType().getName());
		sb.append(".");
		sb.append(handlerMethod.getMethod().getName());
		sb.append("(");
		int i=0;
		for (MethodParameter mp : handlerMethod.getMethodParameters()) {
			sb.append(mp.getParameterType().getName());
			if (++i!=handlerMethod.getMethodParameters().length) {
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}
	
}

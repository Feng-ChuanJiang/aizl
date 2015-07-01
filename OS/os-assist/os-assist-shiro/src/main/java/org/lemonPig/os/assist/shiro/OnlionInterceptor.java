package org.lemonPig.os.assist.shiro;

import org.apache.shiro.aop.MethodInterceptorSupport;
import org.apache.shiro.aop.MethodInvocation;
import org.apache.shiro.subject.Subject;

public class OnlionInterceptor extends MethodInterceptorSupport{
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Subject subject=getSubject();
		return null;
	}

}

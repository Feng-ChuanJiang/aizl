package org.lemonPig.os.assist.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtil implements ApplicationContextAware{
	private static ApplicationContext context;
	
	public void setApplicationContext(ApplicationContext contex) throws BeansException {
		SpringBeanUtil.context = contex;
	}

	public static ApplicationContext getContext() {
		return context;
	}
	
	public static Object getBean(String beanId){
		try {
			if (context!=null){
				return context.getBean(beanId);
			}
		} catch (BeansException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static <T>T getBean(String beanId,Class<T> c){
		try {
			if (context!=null){
				return (T) context.getBean(beanId, c);
			}
		} catch (BeansException e) {
			e.printStackTrace();
		}
		return null;
	}
}

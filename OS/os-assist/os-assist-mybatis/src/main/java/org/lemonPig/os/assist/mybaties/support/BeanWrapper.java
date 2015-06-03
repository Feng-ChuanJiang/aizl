package org.lemonPig.os.assist.mybaties.support;

import java.lang.annotation.Annotation;

import org.lemonPig.os.common.Assert;
import org.lemonPig.os.common.ReflectUtils;

public abstract class BeanWrapper {
	private Annotation annotation;
	private Class<?> beanClass;
	private Object obj;
	public BeanWrapper(Object obj){
		this.obj=obj;
		beanClass=obj.getClass();
		Class<? extends Annotation> annotationClass=supportAnnotation();
		Assert.assertIsTrue(ReflectUtils.hasAnnotation(beanClass, annotationClass), "参数必须申明注解"+annotationClass.getName());
		annotation=ReflectUtils.getAnnotation(beanClass, annotationClass);
	}
	protected abstract Class<? extends Annotation> supportAnnotation();
	protected Annotation getAnnotation() {
		return annotation;
	}
	protected Class<?> getBeanClass() {
		return beanClass;
	}
	public Object getObj() {
		return obj;
	}
	
}

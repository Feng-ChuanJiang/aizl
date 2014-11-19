package org.lemonPig.os.common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ReflectUtils {
	public static PropertyDescriptor[] getPropertiesDescriptor(Object obj) {
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass(),Object.class);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return beanInfo.getPropertyDescriptors();
	}
	public static PropertyDescriptor[] getPropertiesDescriptor(Object obj,Class<?> clazz) {
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass(),clazz);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return beanInfo.getPropertyDescriptors();
	}
	public static Object getFieldValue(Object obj,Field field) {
		field.setAccessible(true);
		Object value = null;
		try {
			value = field.get(obj);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static Class<?> getGenericClass(Field field,int index) {
		Type type=field.getGenericType();
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType=(ParameterizedType)type;
			Type[] types=parameterizedType.getActualTypeArguments();
			return (Class<?>)types[index];
		}
		return null;
	}
	/**
	 * 在目标clazz中获取类型为fieldClass的字段
	 * @param clazz
	 * @param fieldClass
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static Field[] getDeclaredFieldByType(Class<?> clazz,Class<?> fieldClass) throws NoSuchFieldException {
		Field[] fields=clazz.getDeclaredFields();
		List<Field> listResult=new ArrayList<Field>();
		for (Field field : fields) {
			if (fieldClass.isAssignableFrom(field.getClass())) {
				listResult.add(field);
			}
		}
		if (listResult==null||listResult.size()==0) {
			throw new NoSuchFieldException();
		}else {
			Field[] rt=new Field[listResult.size()];
			return listResult.toArray(rt);
		}
	}
	/**
	 * 在目标clazz中获取类型为fieldClass<E extent genericeType>的字段
	 * @param clazz
	 * @param fieldClass
	 * @param genericType
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static Field[] getDeclaredFieldByType(Class<?> clazz,Class<?> fieldClass,Class<?> genericType) throws NoSuchFieldException {
		Field[] fields=clazz.getDeclaredFields();
		List<Field> listResult=new ArrayList<Field>();
		for (Field field : fields) {
			if (fieldClass.isAssignableFrom(field.getType())) {
				Type type=field.getGenericType();
				if (type instanceof ParameterizedType) {
					ParameterizedType parameterizedType=(ParameterizedType)type;
					Class<?> genericClass=(Class<?>)parameterizedType.getActualTypeArguments()[0];
					if (genericClass ==genericType) {
						listResult.add(field);
					}
				}
			}
		}
		if (listResult==null||listResult.size()==0) {
			throw new NoSuchFieldException();
		}else {
			Field[] rt=new Field[listResult.size()];
			return listResult.toArray(rt);
		}
	}
}

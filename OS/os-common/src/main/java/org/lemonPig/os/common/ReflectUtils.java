package org.lemonPig.os.common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectUtils {
//	public static String getClassName(Object obj) {
//		if (obj instanceof Class<?>) {
//			return ((Class<?>) obj).getName();
//		} else {
//			return obj.getClass().getName();
//		}
//	}
	
	public static PropertyDescriptor[] getPropertiesDescriptor(Object obj) {
		return getPropertiesDescriptor(obj, Object.class);
	}
	/**
	 * 内省class
	 * @param obj 内省对象
	 * @param clazz 内省最高层级
	 * @return 
	 */
	public static PropertyDescriptor[] getPropertiesDescriptor(Object obj,
			Class<?> clazz) {
		BeanInfo beanInfo = null;
		Class<?> objClass = null;
		if (obj instanceof Class<?>) {
			objClass = (Class<?>) obj;
		} else {
			objClass = obj.getClass();
		}
		try {
			beanInfo = Introspector.getBeanInfo(objClass, clazz);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return beanInfo.getPropertyDescriptors();
	}

	public static Object getFieldValue(Object obj, Field field) {
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

	/**
	 * 获取字段泛型
	 * 
	 * @param field
	 *            指定字段
	 * @param index
	 *            第几个泛型
	 * @return
	 */
	public static Class<?> getGenericClass(Field field, int index) {
		Type type = field.getGenericType();
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type[] types = parameterizedType.getActualTypeArguments();
			return (Class<?>) types[index];
		}
		return null;
	}

	/**
	 * 在目标clazz中获取类型为fieldClass的字段
	 * 
	 * @param clazz
	 * @param fieldClass
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static Field[] getDeclaredFieldByType(Class<?> clazz,
			Class<?> fieldClass) throws NoSuchFieldException {
		Field[] fields = clazz.getDeclaredFields();
		List<Field> listResult = new ArrayList<Field>();
		for (Field field : fields) {
			if (fieldClass.isAssignableFrom(field.getClass())) {
				listResult.add(field);
			}
		}
		if (listResult == null || listResult.size() == 0) {
			throw new NoSuchFieldException();
		} else {
			Field[] rt = new Field[listResult.size()];
			return listResult.toArray(rt);
		}
	}

	/**
	 * 在目标clazz中获取类型为fieldClass<E extent genericeType>的字段
	 * 
	 * @param clazz
	 * @param fieldClass
	 * @param genericType
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static Field[] getDeclaredFieldByType(Class<?> clazz,
			Class<?> fieldClass, Class<?> genericType)
			throws NoSuchFieldException {
		Field[] fields = clazz.getDeclaredFields();
		List<Field> listResult = new ArrayList<Field>();
		for (Field field : fields) {
			if (fieldClass.isAssignableFrom(field.getType())) {
				Type type = field.getGenericType();
				if (type instanceof ParameterizedType) {
					ParameterizedType parameterizedType = (ParameterizedType) type;
					Class<?> genericClass = (Class<?>) parameterizedType
							.getActualTypeArguments()[0];
					if (genericClass == genericType) {
						listResult.add(field);
					}
				}
			}
		}
		if (listResult == null || listResult.size() == 0) {
			throw new NoSuchFieldException();
		} else {
			Field[] rt = new Field[listResult.size()];
			return listResult.toArray(rt);
		}
	}

	/**
	 * 获取class上的注解
	 * 
	 * @param clazz
	 * @param annotationClass
	 * @return
	 */
	public static <T extends Annotation> T getAnnotation(Class<?> clazz,
			Class<T> annotationClass) {
		return clazz.getAnnotation(annotationClass);
	}

	public static boolean hasAnnotation(Class<?> clazz,
			Class<? extends Annotation> annotationClass) {
		return clazz.isAnnotationPresent(annotationClass);
	}

	/**
	 * Attempt to find a {@link Method} on the supplied class with the supplied
	 * name and no parameters. Searches all superclasses up to {@code Object}.
	 * <p>
	 * Returns {@code null} if no {@link Method} can be found.
	 * 
	 * @param clazz
	 *            the class to introspect
	 * @param name
	 *            the name of the method
	 * @return the Method object, or {@code null} if none found
	 */
	public static Method getMethod(Class<?> clazz, String name) {
		return getMethod(clazz, name, new Class<?>[0]);
	}

	/**
	 * Attempt to find a {@link Method} on the supplied class with the supplied
	 * name and parameter types. Searches all superclasses up to {@code Object}.
	 * <p>
	 * Returns {@code null} if no {@link Method} can be found.
	 * 
	 * @param clazz
	 *            the class to introspect
	 * @param name
	 *            the name of the method
	 * @param paramTypes
	 *            the parameter types of the method (may be {@code null} to
	 *            indicate any signature)
	 * @return the Method object, or {@code null} if none found
	 */
	public static Method getMethod(Class<?> clazz, String name,
			Class<?>... paramTypes) {
		Assert.assertNotNull(clazz, "Class must not be null");
		Assert.assertNotNull(name, "Method name must not be null");
		Class<?> searchType = clazz;
		while (searchType != null) {
			Method[] methods = (searchType.isInterface() ? searchType
					.getMethods() : searchType.getDeclaredMethods());
			for (Method method : methods) {
				if (name.equals(method.getName())
						&& (paramTypes == null || Arrays.equals(paramTypes,
								method.getParameterTypes()))) {
					return method;
				}
			}
			searchType = searchType.getSuperclass();
		}
		return null;
	}

	/**
	 * Invoke the specified {@link Method} against the supplied target object
	 * with no arguments. The target object can be {@code null} when invoking a
	 * static {@link Method}.
	 * <p>
	 * Thrown exceptions are handled via a call to
	 * {@link #handleReflectionException}.
	 * 
	 * @param method
	 *            the method to invoke
	 * @param target
	 *            the target object to invoke the method on
	 * @return the invocation result, if any
	 * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
	 */
	public static Object invokeMethod(Method method, Object target) {
		return invokeMethod(method, target, new Object[0]);
	}

	/**
	 * Invoke the specified {@link Method} against the supplied target object
	 * with the supplied arguments. The target object can be {@code null} when
	 * invoking a static {@link Method}.
	 * <p>
	 * Thrown exceptions are handled via a call to
	 * {@link #handleReflectionException}.
	 * 
	 * @param method
	 *            the method to invoke
	 * @param target
	 *            the target object to invoke the method on
	 * @param args
	 *            the invocation arguments (may be {@code null})
	 * @return the invocation result, if any
	 */
	public static Object invokeMethod(Method method, Object target,
			Object... args) {
		try {
			return method.invoke(target, args);
		} catch (Exception ex) {
			handleReflectionException(ex);
		}
		throw new IllegalStateException("Should never get here");
	}

	/**
	 * Handle the given reflection exception. Should only be called if no
	 * checked exception is expected to be thrown by the target method.
	 * <p>
	 * Throws the underlying RuntimeException or Error in case of an
	 * InvocationTargetException with such a root cause. Throws an
	 * IllegalStateException with an appropriate message else.
	 * 
	 * @param ex
	 *            the reflection exception to handle
	 */
	public static void handleReflectionException(Exception ex) {
		if (ex instanceof NoSuchMethodException) {
			throw new IllegalStateException("没有找到指定名称的method: "
					+ ex.getMessage());
		}
		if (ex instanceof IllegalAccessException) {
			throw new IllegalStateException("无权访问指定的method: " + ex.getMessage());
		}
		if (ex instanceof InvocationTargetException) {
			handleInvocationTargetException((InvocationTargetException) ex);
		}
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		throw new UndeclaredThrowableException(ex);
	}

	public static void handleInvocationTargetException(
			InvocationTargetException ex) {
		rethrowRuntimeException(ex.getTargetException());
	}

	/**
	 * Rethrow the given {@link Throwable exception}, which is presumably the
	 * <em>target exception</em> of an {@link InvocationTargetException}. Should
	 * only be called if no checked exception is expected to be thrown by the
	 * target method.
	 * <p>
	 * Rethrows the underlying exception cast to an {@link RuntimeException} or
	 * {@link Error} if appropriate; otherwise, throws an
	 * {@link IllegalStateException}.
	 * 
	 * @param ex
	 *            the exception to rethrow
	 * @throws RuntimeException
	 *             the rethrown exception
	 */
	public static void rethrowRuntimeException(Throwable ex) {
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		if (ex instanceof Error) {
			throw (Error) ex;
		}
		throw new UndeclaredThrowableException(ex);
	}
}

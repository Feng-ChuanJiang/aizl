package org.lemonPig.os.common;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;




public class ClassUtils {
	private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new HashMap<Class<?>, Class<?>>(8);
	static{
		primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
		primitiveWrapperTypeMap.put(Byte.class, byte.class);
		primitiveWrapperTypeMap.put(Character.class, char.class);
		primitiveWrapperTypeMap.put(Double.class, double.class);
		primitiveWrapperTypeMap.put(Float.class, float.class);
		primitiveWrapperTypeMap.put(Integer.class, int.class);
		primitiveWrapperTypeMap.put(Long.class, long.class);
		primitiveWrapperTypeMap.put(Short.class, short.class);
	}
	public static Class<? extends Object> loadClass(String className){
		Class<? extends Object> clazz = null;
		try {
			clazz = getDefaultClassLoader().loadClass(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clazz;
		// Object obj = objClass.newInstance();
	}
	public static Class<? extends Object>[] loadClasses(String packageName)  {
		Class<? extends Object>[] classes=null;
		String packagePath = "classpath:" + packageName.replace(".", "/");
		File packageFile = FileUtils.getResourcAsFile(packagePath);
		File[] classFiles = packageFile.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.toLowerCase().endsWith(".class")) {
					return true;
				} else {
					return false;
				}
			}
		});
		classes=new Class<?>[classFiles.length];
		int i=0;
		for (File classFile : classFiles) {
			String className=packagePath+"/"+classFile.getName();
			classes[i++]=loadClass(className);
		}
		return classes;
	}
	public static <T>T newInstance(Class<T> clazz) {
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}
	@SuppressWarnings("unchecked")
	public static <T>T newInstance(String className) {
		Class<? extends Object> clazz = loadClass(className);
		T t=null;
		try {
			t=(T) newInstance(clazz);
		} catch (ClassCastException e) {
			e.printStackTrace();		}
		return t;
	}

	public static Object[] newInstances(String packageName){
		Object[] objects=null;
		Class<?>[] classes=loadClasses(packageName);
		objects=new Object[classes.length];
		int i=0;
		for (Class<?> clazz : classes) {
			try {
				objects[i++]=clazz.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();			} 
			catch (IllegalAccessException e) {
					e.printStackTrace();
			}
		}
		return objects;
	}

	/**
	 * 获取默认的类加载器，首先尝试获取当前线程的类加载器，如果为null，通过ClassUill获取类加载器
	 * 
	 * @return
	 */
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Throwable ex) {
		}
		if (cl == null)
			cl = (ClassUtils.class).getClassLoader();
		return cl;
	}
	public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
		return (clazz.isPrimitive() || isPrimitiveWrapper(clazz));
	}
	public static boolean isPrimitiveWrapper(Class<?> clazz) {
		return primitiveWrapperTypeMap.containsKey(clazz);
	}
	public static boolean isCollection(Class<?> clazz) {
		return Collection.class.isAssignableFrom(clazz);
	}
	public static boolean isMap(Class<?> clazz) {
		return Map.class.isAssignableFrom(clazz);
	}
	@SuppressWarnings("unchecked")
	public static boolean hasAnnotation(Class<?> clazz,Class<? extends Annotation>... annotationClasses) {
		for (Class<? extends Annotation> annotationClass : annotationClasses) {
			if (clazz.isAnnotationPresent(annotationClass)) {
				return true;
			}
		}
		return false;
	}
}

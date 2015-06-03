package org.lemonPig.os.web.vo;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class DataTablesVO {

	public static class KeyValuePair {
		private String name;
		private String value;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
	public static Map<String, Object> toMap(KeyValuePair... keyValuePairs) {
		if (keyValuePairs==null) {
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		for (KeyValuePair kvp : keyValuePairs) {
			map.put(kvp.getName(), kvp.getValue());
		}
		return map;
	}
	public static <T>T toBean(Class<T> clazz,KeyValuePair... keyValuePairs){
		T t=null;
		try {
			t = clazz.newInstance();
			Map<String, Object> map=toMap(keyValuePairs);
			BeanUtils.copyProperties(t, map);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;
	}
}

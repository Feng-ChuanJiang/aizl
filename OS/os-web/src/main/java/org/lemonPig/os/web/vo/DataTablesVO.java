package org.lemonPig.os.web.vo;

import java.util.HashMap;
import java.util.Map;

public class DataTablesVO {
	public static Map<String, Object> toMap(KeyValuePairVO... keyValuePairVOs) {
		if (keyValuePairVOs==null) {
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		for (KeyValuePairVO kvp : keyValuePairVOs) {
			map.put(kvp.getName(), kvp.getValue());
		}
		return map;
	}
	public static class KeyValuePairVO {
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
}

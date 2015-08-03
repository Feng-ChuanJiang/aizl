package org.lemonPig.os.web.vo;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.lemonPig.os.common.Assert;

public class DataTables {
	public static final String startKeyName="iDisplayStart";
	public static final String lengthKeyName="iDisplayLength";
	private Map<String, Object> map;
	public DataTables(KeyValuePair[] kvps){
		map=toMap(kvps);
	}
	public static class ColNames{
		public static String[] userManage={"ID"};
	}
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
	public String[] getOrderBy(String[] colNames) {
		Object obj=map.get("iSortingCols");
		if (obj==null) {
			return new String[]{""};
		}
		//需要排序的列数
		int iSortingCols=Integer.parseInt(obj.toString());
		String[] orderBys=new String[iSortingCols];
		//获取需排序列参数的key前缀
		String sortColKeyPre="iSortCol_";
		//排序方式参数的key前缀
		String sortDirKeyPre="sSortDir_";
		for (int i = 0; i < iSortingCols; i++) {
			int needOrderColNum=Integer.parseInt(map.get(sortColKeyPre+i).toString());
			Assert.assertGt(colNames.length, needOrderColNum, "根据列号获取排序列名异常，排序列号超出可排序列名数组范围，列号："+needOrderColNum+"列名数组："+colNames);
			String colName=colNames[needOrderColNum];
			String sortDir=map.get(sortDirKeyPre+i).toString();
			orderBys[i]=colName+" "+sortDir;
		}
		return orderBys;
	}
	private Map<String, Object> toMap(KeyValuePair... keyValuePairs) {
		if (keyValuePairs==null) {
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		for (KeyValuePair kvp : keyValuePairs) {
			map.put(kvp.getName(), kvp.getValue());
		}
		return map;
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
	public <T>T getBean(Class<T> clazz){
		T t=null;
		try {
			t = clazz.newInstance();
			BeanUtils.copyProperties(t, this.map);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;
	}
}

package org.lemonPig.os;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public int getMiddle(Integer[] list, int low, int high) {
		int tmp = list[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] > tmp) {
				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			while (low < high && list[low] < tmp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	public void _quickSort(Integer[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // 将list数组进行一分为二
			_quickSort(list, low, middle - 1); // 对低字表进行递归排序
			_quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
	}

	public void quick(Integer[] str) {
		if (str.length > 0) { // 查看数组是否为空
			_quickSort(str, 0, str.length - 1);
		}
	}

	@org.junit.Test
	public void test() {
		// TODO Auto-generated method stub
		Integer[] list = { 34, 3, 53, 2, 23, 7, 14, 10 };
		quick(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	
	@org.junit.Test
	public void testSingleton() {
		Teacher t1=new Teacher();
		t1.setA("1");
		Teacher t2=new Teacher();
		t2.setA("2");
		t1.setT(t2);
		Map<String, Object> map=new HashMap<String, Object>();
		objectToMap(t1,"teacher" ,map);
		System.out.println(map);
	}
	private void objectToMap(Object obj,String alias,Map<String, Object> map){
		if (map==null) {
			throw new IllegalArgumentException();
		}
		Class<?> clazz=obj.getClass();
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(clazz,Object.class);
		} catch (IntrospectionException e1) {
			e1.printStackTrace();
		}
		for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
			String key=alias+"."+pd.getName();
			Object value=null;
			try {
				value=pd.getReadMethod().invoke(obj);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			if (value==null) {
				continue;
			}
			if (value.getClass().equals(obj.getClass())) {
				objectToMap(value,clazz.getSimpleName().toLowerCase()+"."+pd.getName(), map);
			}else {
				map.put(key, value);
			}
		}
	}
}

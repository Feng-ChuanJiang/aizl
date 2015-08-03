package org.lemonPig.os.core.util;

import java.util.ArrayList;
import java.util.List;

import org.lemonPig.os.assist.mybaties.bean.PageList;
import org.lemonPig.os.assist.mybaties.bean.Paginator;
import org.lemonPig.os.common.Assert;
import org.lemonPig.os.common.ClassUtils;
import org.lemonPig.os.core.support.Page;
import org.springframework.beans.BeanUtils;

public class SwitchUtils {
	public static <T>List<T> toVoList(Class<T> voClass,List<?> pojoList) {
		Assert.assertNotNull(voClass, "voClass不能为空!");
		Assert.assertNotNull(pojoList, "pojoList不能为空!");
		List<T> list=new ArrayList<T>();
		for (Object pojo : pojoList) {
			T t=ClassUtils.newInstance(voClass);
			BeanUtils.copyProperties(pojo, t);
			list.add(t);
		}
		return list;
	}
	public static <T>PageList<T> toVoPageList(Class<T> voClass,PageList<?> pojoPageList){
		PageList<T> pageList=new PageList<T>(pojoPageList.getPaginator());
		for (Object pojo : pojoPageList) {
			T t=ClassUtils.newInstance(voClass);
			BeanUtils.copyProperties(pojo, t);
			pageList.add(t);
		}
		return pageList;
	}
}

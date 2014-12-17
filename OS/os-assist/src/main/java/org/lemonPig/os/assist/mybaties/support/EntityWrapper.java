package org.lemonPig.os.assist.mybaties.support;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.lemonPig.os.assist.mybaties.annotation.Entity;
import org.lemonPig.os.assist.mybaties.bean.Column;
import org.lemonPig.os.common.ReflectUtils;

public class EntityWrapper extends BeanWrapper {
	public EntityWrapper(Object obj) {
		super(obj);
	}

	@Override
	protected Class<? extends Annotation> supportAnnotation() {
		return Entity.class;
	}

	public String getTableName() {
		Entity entity = (Entity) getAnnotation();
		return entity.tableName();
	}

	public String getAlias() {
		Entity entity = (Entity) getAnnotation();
		return entity.alias();
	}
	public List<Column> getColumns()  {
		List<Column> columns=new ArrayList<Column>();
		for (PropertyDescriptor propertyDescriptor : ReflectUtils.getPropertiesDescriptor(getBeanClass())) {
			Column column=new Column();
			String propertyName=propertyDescriptor.getName();
			column.setName(propertyName);
			try {
				column.setValue(propertyDescriptor.getReadMethod().invoke(getObj()));
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			columns.add(column);
		}
		return columns;
	}
}

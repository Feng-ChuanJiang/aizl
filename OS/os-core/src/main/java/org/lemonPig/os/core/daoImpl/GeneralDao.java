package org.lemonPig.os.core.daoImpl;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.lemonPig.os.assist.mybaties.bean.PageList;
import org.lemonPig.os.common.Assert;
import org.lemonPig.os.common.ReflectUtils;
import org.lemonPig.os.core.idao.IGeneralDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GeneralDao<T, K, E> extends SqlSessionDaoSupport implements
		IGeneralDao<T, K, E> {
	Object original;
	K mapper;
	Class<T> pojoClass;
	Class<K> mapperClass;
	Class<E> exampleClass;
	@SuppressWarnings("unchecked")
	public GeneralDao() {
		Type genType = this.getClass().getGenericSuperclass();
		// 子类构造时进入
		if (genType instanceof ParameterizedType) {
			Type[] params = ((ParameterizedType) genType)
					.getActualTypeArguments();
			// 第一个泛型定义为mapper的类型
			this.pojoClass = (Class<T>) params[0];
			this.mapperClass = (Class<K>) params[1];
			this.exampleClass = (Class<E>) params[2];
		}
	}

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		this.mapper = getSqlSession().getMapper(mapperClass);
	}
	@Override
	public int countByExample(E example) {
		Method countMethod = ReflectUtils.getMethod(mapperClass,
				"countByExample", exampleClass);
		return (int) ReflectUtils.invokeMethod(countMethod, mapper, example);
	}
	@Override
	public int deleteByExample(E example) {
		Method deleteMethod = ReflectUtils.getMethod(mapperClass,
				"deleteByExample", exampleClass);
		return (int) ReflectUtils.invokeMethod(deleteMethod, mapper, example);
	}
	@Override
	public void deleteByPrimaryKey(Object pk) {
		Assert.assertNotNull(pk, "按主键删除错误，主键值不能为空");
		Method deleteMethod = ReflectUtils.getMethod(mapperClass,
				"deleteByPrimaryKey", pk.getClass());
		int count = (int) ReflectUtils.invokeMethod(deleteMethod, mapper, pk);
		Assert.assertEqual(count, 1, "数据删除失败，删除记录数应为：1，实际影响记录数为：" + count);
	}

	@Override
	public void insert(T pojo) {
		Assert.assertNotNull(pojo, "数据库保存错误，保存对象为空");
		// 执行方法：int insert(User record);
		Method insertMethod = ReflectUtils.getMethod(mapperClass, "insert",
				pojoClass);
		int count = (int) ReflectUtils.invokeMethod(insertMethod, mapper, pojo);
		Assert.assertEqual(count, 1, "数据插入失败，插入记录数应为：1，实际影响记录数为：" + count);
	}

	@Override
	public void insertSelective(T pojo) {
		Assert.assertNotNull(pojo, "数据库保存错误，保存对象为空");
		// 执行方法：int insert(User record);
		Method insertMethod = ReflectUtils.getMethod(mapperClass,
				"insertSelective", pojoClass);
		int count = (int) ReflectUtils.invokeMethod(insertMethod, mapper, pojo);
		Assert.assertEqual(count, 1, "数据插入失败，插入记录数应为：1，实际影响记录数为：" + count);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectByExample(E example) {
		Method selectMethod = ReflectUtils.getMethod(mapperClass,
				"selectByExample", exampleClass);
		List<T> list = (List<T>) ReflectUtils.invokeMethod(selectMethod,
				mapper, example);
		return list;
	}
	@Override
	public T selectOneByExample(E example) {
		List<T> list= selectByExample(example);
		Assert.assertLengthEqual(list, 1, "查询单条记录异常，查询结果数量为："+list.size());
		return list.get(0);
	}
	@Override
	public PageList<T> selectPageByExample(E example,Integer start,Integer length) {
		RowBounds rowBounds=new RowBounds(start, length);
		List<T> list= getSqlSession().selectList(mapperClass.getName()+".selectByExample", example, rowBounds);
		PageList<T> pageList=(PageList<T>) list;
		return pageList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T selectByPrimaryKey(Object pk) {
		Method selectMethod = ReflectUtils.getMethod(mapperClass,
				"selectByExample", pk.getClass());
		T t = (T) ReflectUtils.invokeMethod(selectMethod, mapper, pk);
		return t;
	}
	
	
	/**
	 * 按条件更新，更新字段根据pojo属性是否非空选择性添加
	 * 
	 * @param pojo
	 *            需要更新的对象
	 * @param example
	 *            更新条件
	 * @return
	 */
	@Override
	public int updateByExampleSelective(T pojo, E example) {
		Assert.assertNotNull(pojo, "数据库更新错误，更新对象为空");
		Method updateMethod = ReflectUtils.getMethod(mapperClass,
				"updateByExampleSelective", pojoClass, exampleClass);
		int count = (int) ReflectUtils.invokeMethod(updateMethod, mapper, pojo,
				example);
		return count;
	}
	@Override
	public int updateByExample(T pojo, E example) {
		Assert.assertNotNull(pojo, "数据库更新错误，更新对象为空");
		Method updateMethod = ReflectUtils.getMethod(mapperClass,
				"updateByExample", pojoClass, exampleClass);
		int count = (int) ReflectUtils.invokeMethod(updateMethod, mapper, pojo,
				example);
		return count;
	}
	@Override
	public void updateByPrimaryKeySelective(T pojo) {
		Assert.assertNotNull(pojo, "数据库更新错误，更新对象为空");
		Method updateMethod = ReflectUtils.getMethod(mapperClass,
				"updateByPrimaryKeySelective", pojoClass, exampleClass);
		int count = (int) ReflectUtils.invokeMethod(updateMethod, mapper, pojo);
		Assert.assertEqual(count, 1, "数据按主键更新错误，更新记录数应为：1，实际影响记录数为：" + count);
	}
	@Override
	public void updateByPrimaryKey(T pojo) {
		Assert.assertNotNull(pojo, "数据库更新错误，更新对象为空");
		Method updateMethod = ReflectUtils.getMethod(mapperClass,
				"updateByPrimaryKey", pojoClass, exampleClass);
		int count = (int) ReflectUtils.invokeMethod(updateMethod, mapper, pojo);
		Assert.assertEqual(count, 1, "数据按主键更新错误，更新记录数应为：1，实际影响记录数为：" + count);
	}

}

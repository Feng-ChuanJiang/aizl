package org.lemonPig.os.core.idao;

import java.util.List;

import org.lemonPig.os.assist.mybaties.bean.PageList;

public interface IGeneralDao<T, K, E> {
	void insert(T t);

	void insertSelective(T pojo);

	int countByExample(E example);

	int deleteByExample(E example);

	void deleteByPrimaryKey(Object pk);

	List<T> selectByExample(E example);

	PageList<T> selectPageByExample(E example, Integer start, Integer length);

	T selectByPrimaryKey(Object pk);

	int updateByExampleSelective(T pojo, E example);

	int updateByExample(T pojo, E example);

	void updateByPrimaryKeySelective(T pojo);

	void updateByPrimaryKey(T pojo);

	T selectOneByExample(E example);

}

package org.lemonPig.os.core.daoImpl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.lemonPig.os.assist.mybaties.bean.Crud;
import org.lemonPig.os.assist.mybaties.bean.Crud.Insert;
import org.lemonPig.os.core.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralDao<T> extends SqlSessionDaoSupport  {

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	public void save(T t) {
		Insert insert=new Crud.Insert(t);
		getSqlSession().insert("generalSave",insert);
	}
}

package org.lemonPig.os.core.daoImpl;

import org.lemonPig.os.core.idao.IUserDao;
import org.lemonPig.os.core.mapper.ShiroUserMapper;
import org.lemonPig.os.core.mapper.UserPOJOMapper;
import org.lemonPig.os.core.pojo.UserPOJO;
import org.lemonPig.os.core.pojo.UserPOJOExample;
import org.lemonPig.os.core.vo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GeneralDao<UserPOJO,UserPOJOMapper,UserPOJOExample> implements IUserDao{
	@Override
	public User selectLoginUserByUsername(String username) {
		ShiroUserMapper mapper=getSqlSession().getMapper(ShiroUserMapper.class);
		User user=mapper.selectLoginUserByUsername(username);
		return user;
	}
}

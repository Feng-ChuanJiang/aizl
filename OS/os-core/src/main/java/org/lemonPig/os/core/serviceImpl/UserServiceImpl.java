package org.lemonPig.os.core.serviceImpl;

import org.lemonPig.os.core.dto.User;
import org.lemonPig.os.core.idao.IUserDao;
import org.lemonPig.os.core.iservice.IUserService;
import org.lemonPig.os.core.pojo.UserPOJO;
import org.lemonPig.os.core.pojo.UserPOJOExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	IUserDao iUserDao;
	@Override
	public User findUserByUserName(String username) {
		User user=new User();
		UserPOJOExample userPOJOExample=new UserPOJOExample();
		userPOJOExample.createCriteria().andUserNameEqualTo(username);
		UserPOJO userPOJO=iUserDao.selectOneByExample(userPOJOExample);
		BeanUtils.copyProperties(userPOJO, user);
		return user;
	}
	@Override
	public void saveUser(User user) {
		UserPOJO userPOJO=new UserPOJO();
		BeanUtils.copyProperties(user, userPOJO);
		iUserDao.insert(userPOJO);
	}

}

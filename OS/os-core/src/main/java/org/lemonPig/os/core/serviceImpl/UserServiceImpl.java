package org.lemonPig.os.core.serviceImpl;

import org.lemonPig.os.core.idao.IUserDao;
import org.lemonPig.os.core.iservice.IUserService;
import org.lemonPig.os.core.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
//	@Autowired
//	IUserDao iUserDao;
	@Override
	public User findUserByUserName(String username) {
		return null;
//		return iUserDao.findUserByName(username);
	}

}

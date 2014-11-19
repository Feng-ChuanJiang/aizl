package org.lemonPig.os.core.iservice;

import org.lemonPig.os.core.pojo.User;


public interface IUserService {
	User findUserByUserName(String username);
}

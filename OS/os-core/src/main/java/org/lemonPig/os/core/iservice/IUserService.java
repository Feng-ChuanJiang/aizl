package org.lemonPig.os.core.iservice;

import org.lemonPig.os.core.dto.User;


public interface IUserService {
	User findUserByUserName(String username);
	void saveUser(User user);
}

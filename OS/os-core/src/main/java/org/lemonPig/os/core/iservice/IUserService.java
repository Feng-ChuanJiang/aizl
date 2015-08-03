package org.lemonPig.os.core.iservice;

import org.lemonPig.os.assist.mybaties.bean.PageList;
import org.lemonPig.os.core.vo.User;


public interface IUserService {
	User findLoginUserByUserName(String username);
	PageList<User> findUserByPage(String orUsername, String orMail,
			String orTel, int start, int length, String[] orderBys);
	void saveUser(User user);
}

package org.lemonPig.os.core.idao;

import org.lemonPig.os.core.pojo.User;

public interface IUserDao {
	User findUserByName(String username);
}

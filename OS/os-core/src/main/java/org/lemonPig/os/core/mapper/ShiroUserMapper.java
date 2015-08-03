package org.lemonPig.os.core.mapper;

import org.lemonPig.os.core.vo.User;

public interface ShiroUserMapper {
	User selectLoginUserByUsername(String username);
}

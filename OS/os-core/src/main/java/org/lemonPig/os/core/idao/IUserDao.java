package org.lemonPig.os.core.idao;

import org.lemonPig.os.core.mapper.UserPOJOMapper;
import org.lemonPig.os.core.pojo.UserPOJO;
import org.lemonPig.os.core.pojo.UserPOJOExample;
import org.lemonPig.os.core.vo.User;


public interface IUserDao extends IGeneralDao<UserPOJO,UserPOJOMapper,UserPOJOExample>{

	User selectLoginUserByUsername(String username);
}

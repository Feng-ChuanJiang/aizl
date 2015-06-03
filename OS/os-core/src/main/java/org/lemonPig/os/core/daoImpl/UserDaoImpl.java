package org.lemonPig.os.core.daoImpl;

import org.lemonPig.os.core.idao.IUserDao;
import org.lemonPig.os.core.mapper.UserPOJOMapper;
import org.lemonPig.os.core.pojo.UserPOJO;
import org.lemonPig.os.core.pojo.UserPOJOExample;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GeneralDao<UserPOJO,UserPOJOMapper,UserPOJOExample> implements IUserDao{
}

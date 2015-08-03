package org.lemonPig.os.core.daoImpl;

import org.lemonPig.os.core.idao.IUserMetaDataDao;
import org.lemonPig.os.core.mapper.UserMetadataPOJOMapper;
import org.lemonPig.os.core.pojo.UserMetadataPOJO;
import org.lemonPig.os.core.pojo.UserMetadataPOJOExample;
import org.springframework.stereotype.Repository;

@Repository("iUserMetaDataDao")
public class UserMetaDataDaoImpl extends GeneralDao<UserMetadataPOJO,UserMetadataPOJOMapper,UserMetadataPOJOExample> implements IUserMetaDataDao{

}

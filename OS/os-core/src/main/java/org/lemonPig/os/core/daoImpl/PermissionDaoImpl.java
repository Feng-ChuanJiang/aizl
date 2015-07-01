package org.lemonPig.os.core.daoImpl;

import org.lemonPig.os.core.idao.IPermissionDao;
import org.lemonPig.os.core.mapper.PermissionPOJOMapper;
import org.lemonPig.os.core.pojo.PermissionPOJO;
import org.lemonPig.os.core.pojo.PermissionPOJOExample;
import org.springframework.stereotype.Repository;

@Repository("iPermissionDao")
public class PermissionDaoImpl extends GeneralDao<PermissionPOJO, PermissionPOJOMapper, PermissionPOJOExample> implements IPermissionDao{
	
}

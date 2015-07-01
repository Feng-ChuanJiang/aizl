package org.lemonPig.os.core.daoImpl;

import org.lemonPig.os.core.idao.IResourceDao;
import org.lemonPig.os.core.mapper.ResourcePOJOMapper;
import org.lemonPig.os.core.pojo.ResourcePOJO;
import org.lemonPig.os.core.pojo.ResourcePOJOExample;
import org.springframework.stereotype.Repository;

@Repository("iResourceDao")
public class ResourceDaoImpl extends GeneralDao<ResourcePOJO,ResourcePOJOMapper, ResourcePOJOExample> implements IResourceDao{
	
}

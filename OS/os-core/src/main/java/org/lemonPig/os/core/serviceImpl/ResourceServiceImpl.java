package org.lemonPig.os.core.serviceImpl;

import java.util.List;

import org.lemonPig.os.core.idao.IResourceDao;
import org.lemonPig.os.core.iservice.IResourceService;
import org.lemonPig.os.core.pojo.ResourcePOJO;
import org.lemonPig.os.core.pojo.ResourcePOJOExample;
import org.lemonPig.os.core.vo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("iResourceService")
public class ResourceServiceImpl implements IResourceService{
	@Autowired
	IResourceDao iResourceDao;
	@Transactional(rollbackFor=Exception.class)
	@Override
	public List<Resource> findResourcesByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void save(Resource resource) {
		ResourcePOJO resourcePOJO=new ResourcePOJO();
		BeanUtils.copyProperties(resource, resourcePOJO);
		iResourceDao.insert(resourcePOJO);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void deleteAll(){
		iResourceDao.deleteByExample(new ResourcePOJOExample());
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void updateOrSaveByHandlerMethod(List<Resource> resources){
		ResourcePOJO resourcePOJO=new ResourcePOJO();
		ResourcePOJOExample resourcePOJOExample=new ResourcePOJOExample();
		for (Resource resource : resources) {
			BeanUtils.copyProperties(resource, resourcePOJO);
			resourcePOJOExample.createCriteria().andHandlermethodEqualTo(resource.getHandlermethod());
			iResourceDao.updateByExampleSelective(resourcePOJO, resourcePOJOExample);
		}
	}
}

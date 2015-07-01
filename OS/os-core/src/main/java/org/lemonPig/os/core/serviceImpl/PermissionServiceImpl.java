package org.lemonPig.os.core.serviceImpl;

import org.lemonPig.os.core.dto.Permission;
import org.lemonPig.os.core.idao.IPermissionDao;
import org.lemonPig.os.core.iservice.IPermissionService;
import org.lemonPig.os.core.pojo.PermissionPOJO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iPermissionService")
public class PermissionServiceImpl implements IPermissionService{
	@Autowired
	IPermissionDao iPermissionDao;
	
	@Override
	public void save(Permission permission) {
		PermissionPOJO permissionPOJO=new PermissionPOJO();
		BeanUtils.copyProperties(permission, permissionPOJO);
		iPermissionDao.insert(permissionPOJO);
	}
}

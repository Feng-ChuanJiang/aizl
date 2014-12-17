package org.lemonPig.os.core.iservice;

import java.util.List;

import org.lemonPig.os.core.pojo.Permission;

public interface IResourceService {
	List<Permission> findResourcesByUserName(String username);
}

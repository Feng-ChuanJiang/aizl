package org.lemonPig.os.core.iservice;

import java.util.List;

import org.lemonPig.os.core.vo.Resource;

public interface IResourceService {
	List<Resource> findResourcesByUserName(String username);
	
	void save(Resource resource);

	void deleteAll();

	void updateOrSaveByHandlerMethod(List<Resource> resources);
}

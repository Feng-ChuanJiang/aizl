package org.lemonPig.os.core.iservice;

import java.util.List;
import java.util.Set;

import org.lemonPig.os.core.dto.Role;

public interface IRoleService {

	List<Role> findRoleByUserName(String username);
	
	Set<String> findRoleNameByUserName(String username);
}

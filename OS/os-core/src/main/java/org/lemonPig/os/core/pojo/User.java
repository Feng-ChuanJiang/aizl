package org.lemonPig.os.core.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lemonPig.os.core.constants.UserStatus;

/**
 * @author ai.zhanglin
 *
 */
public class User {
	private Long id;
	private String userName;
	private String passWord;
	private UserStatus status;
	private String salt;
	private List<Resource> resources;
	private List<Role> roles;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Set<String> getRoleENames() {
		Set<String> roleNameSet=new HashSet<String>();
		if (roles!=null) {
			for (Role role : roles) {
				roleNameSet.add(role.getEname());
			}
		}
		return roleNameSet;
	}
	public Set<String> getPermissions() {
		Set<String> permissionss=new HashSet<String>();
		List<Resource> resources=new ArrayList<Resource>();
		if (roles!=null) {
			for (Role role : roles) {
				resources.addAll(role.getResources());
			}
		}
		resources.addAll(this.resources);
		for (Resource resource : resources) {
			permissionss.add(resource.getPermission());
		}
		return permissionss;
	}
}

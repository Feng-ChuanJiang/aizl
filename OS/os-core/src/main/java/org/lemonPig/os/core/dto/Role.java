package org.lemonPig.os.core.dto;

import java.util.List;

import org.lemonPig.os.core.constants.GrantAble;



public class Role {
	private Long id;
	private String ename;
	private String cname;
	private List<Resource> resources;
	private List<User> users;
	private GrantAble grantAble;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public GrantAble getGrantAble() {
		return grantAble;
	}
	public void setGrantAble(GrantAble grantAble) {
		this.grantAble = grantAble;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
}

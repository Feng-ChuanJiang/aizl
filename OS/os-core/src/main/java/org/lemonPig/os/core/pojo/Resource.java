package org.lemonPig.os.core.pojo;


import org.lemonPig.os.core.constants.GrantAble;

public class Resource {
	private Long id;
	private String ename;
	private String cname;
	private String permission;
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
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public GrantAble getGrantAble() {
		return grantAble;
	}
	public void setGrantAble(GrantAble grantAble) {
		this.grantAble = grantAble;
	}
	
}

package org.lemonPig.os.core.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lemonPig.os.assist.mybaties.annotation.Entity;
import org.lemonPig.os.core.constants.UserStatus;

/**
 * @author ai.zhanglin
 *
 */
@Entity(alias = "User", tableName = "user")
public class User {
	private Long id;
	private String userName;
	private String passWord;
	private UserStatus status;
	private String salt;
	private String tel;
	private String mail;
	private List<Permission> permissions=new ArrayList<Permission>();
	private List<Role> roles=new ArrayList<Role>();
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
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
		List<Permission> resources=new ArrayList<Permission>();
		if (roles!=null) {
			for (Role role : roles) {
				resources.addAll(role.getPermissions());
			}
		}
		resources.addAll(this.permissions);
		for (Permission resource : resources) {
			permissionss.add(resource.getPermission());
		}
		return permissionss;
	}
}

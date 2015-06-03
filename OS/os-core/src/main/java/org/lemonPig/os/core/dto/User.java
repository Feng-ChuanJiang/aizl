package org.lemonPig.os.core.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private Long id;

    private String userName;

    private String passWord;
    
    private Integer status;
    
    private String salt;

    private String tel;

    private String mail;

    /**
     * 用户拥有的角色
     */
    private List<Role> roles=new ArrayList<Role>();
    
    private List<Resource> resources=new ArrayList<Resource>();
    
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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
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

	public Set<String> getPermissionNames() {
		Set<String> permissions=new HashSet<String>();
		List<Resource> resources=new ArrayList<Resource>();
		if (roles!=null) {
			for (Role role : roles) {
				resources.addAll(role.getResources());
			}
		}
		resources.addAll(this.resources);
		for (Resource resource : resources) {
			permissions.add(resource.getPermission());
		}
		return permissions;
	}



}
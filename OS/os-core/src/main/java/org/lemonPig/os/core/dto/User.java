package org.lemonPig.os.core.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.ScriptAssert;
import org.lemonPig.os.assist.spring.jsr.First;
import org.lemonPig.os.assist.spring.jsr.Save;
import org.lemonPig.os.assist.spring.jsr.Second;
import org.lemonPig.os.assist.spring.jsr.Update;

@GroupSequence(value = {First.class,Second.class,User.class})
@ScriptAssert(script = "user.passWord==user.confirmation", lang = "javascript", alias = "user", message = "{OS_USR_PASSWORD_NOT_SAME}")  
public class User {
    private Long id;
    @NotNull(message="{OS_USR_USERNAME_NULL}",groups={Save.class})
    private String userName;
    @NotNull(message="{OS_USR_PASSWORD_NULL}",groups={Save.class,Update.class})
    private String passWord;
    private String confirmation;
    private Integer status;
    
    private String salt;
    @NotNull(message="{OS_USR_TEL_NULL}",groups={Save.class,First.class})
    @Pattern(regexp="^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$",message="{OS_USR_TEL_FAILE}",groups={Save.class,Second.class})
    private String tel;
    @NotNull(message="{OS_USR_MAIL_NULL}",groups={Save.class,First.class})
    @Email(message="{OS_USR_MAIL_FAILE}",groups={Save.class,Second.class})
    private String mail;

    /**
     * 用户拥有的角色
     */
    private List<Role> roles=new ArrayList<Role>();
    private Set<Permission> permissions=new HashSet<Permission>();
    
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

    public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
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

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
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

	public Set<String> getPermissionNames() {
		Set<String> permissionsNames=new HashSet<String>();
		
		if (roles!=null) {
			for (Role role : roles) {
				for (Permission rolePermission : role.getPermissions()) {
					permissionsNames.add(rolePermission.getEname());
				}
			}
		}
		for (Permission permission : permissions) {
			permissionsNames.add(permission.getEname());
		}
		return permissionsNames;
	}



}
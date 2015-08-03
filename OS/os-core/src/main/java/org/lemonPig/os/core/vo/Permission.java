package org.lemonPig.os.core.vo;

public class Permission {
    private Long id;

    private String cname;

    private String ename;
    
    private Integer grantable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

	public Integer getGrantable() {
		return grantable;
	}

	public void setGrantable(Integer grantable) {
		this.grantable = grantable;
	}

  
}
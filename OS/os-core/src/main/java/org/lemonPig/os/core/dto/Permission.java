package org.lemonPig.os.core.dto;

public class Permission {
    private Long id;

    private String cname;

    private String ename;
    
    private Byte grantable;

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

    public Byte getGrantable() {
        return grantable;
    }

    public void setGrantable(Byte grantable) {
        this.grantable = grantable;
    }
}
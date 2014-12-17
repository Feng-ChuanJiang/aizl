package org.lemonPig.os.core.constants;

public enum UserStatus {
	ACTIVEED("活动的"),LOCKED("锁定的"),DISCARDED("废弃的");
	private String cname;
	private UserStatus(String cname){
		this.cname=cname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}

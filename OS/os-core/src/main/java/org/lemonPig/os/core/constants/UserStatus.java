package org.lemonPig.os.core.constants;

public enum UserStatus {
	ACTIVEED("活动的"),LOCKED("锁定的"),DISCARDED("废弃的");
	private String cName;
	private UserStatus(String cName){
		this.cName=cName;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
}

package org.lemonPig.os.core.constants;

public enum UserStatus {
	ACTIVEED(0,"活动的"),LOCKED(1,"锁定的"),DISCARDED(2,"废弃的");
	private String name;
	private int code;
	private UserStatus(int code,String name){
		this.name=name;
		this.code=code;
	}
	public String getName() {
		return name;
	}
	public int getCode() {
		return code;
	}
	
}

package org.lemonPig.os.core.constants;

public enum Grantable {
	ENABLED(0,"允许授权"),DISABLED(1,"不可授权");
	private String cname;
	private int code;
	Grantable(int code,String cname){
		this.cname=cname;
		this.code=code;
	}
	@Override
	public String toString() {
		return this.cname;
	}
	public int getCode() {
		return code;
	}
	
}

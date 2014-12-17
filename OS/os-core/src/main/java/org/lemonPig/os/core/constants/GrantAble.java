package org.lemonPig.os.core.constants;

public enum GrantAble {
	ENABLED("允许授权"),DISABLED("不可授权");
	private String cname;
	GrantAble(String cname){
		this.cname=cname;
	}
	@Override
	public String toString() {
		return this.cname;
	}
	
}

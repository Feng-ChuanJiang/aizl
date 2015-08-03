package org.lemonPig.os.core.constants;

/**
 * @author Administrator
 *
 */
public enum Sex{
	MAN(0,"男"),WOMAN(1,"女");
	private String cname;
	private int code;
	private Sex(int code,String cname){
		this.cname=cname;
		this.code=code;
	}
	public String getName() {
		return cname;
	}
	public int getCode() {
		return code;
	}
	
}

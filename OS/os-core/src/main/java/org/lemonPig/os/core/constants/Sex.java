package org.lemonPig.os.core.constants;

/**
 * @author Administrator
 *
 */
public enum Sex{
	MAN("男"),WOMAN("女");
	private String cname;
	private Sex(String cname){
		this.cname=cname;
	}
	@Override
	public String toString() {
		return this.cname;
	}
	
}

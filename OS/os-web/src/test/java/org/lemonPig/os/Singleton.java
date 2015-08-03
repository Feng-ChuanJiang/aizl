package org.lemonPig.os;

public enum Singleton {
	INSTANSE;
	public static Singleton getInstans(){
		return INSTANSE;
	}
	public String outPut() {
		return Thread.currentThread().getId()+"";
	}
}

package org.lemonPig.os.assist.spring;

public class BizException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BizException(){
		super();
	}
	public BizException(String msg){
		super(msg);
	}
	public BizException(Throwable e){
		super(e);
	}
	public BizException(String msg,Throwable e){
		super(msg, e);
	}
}

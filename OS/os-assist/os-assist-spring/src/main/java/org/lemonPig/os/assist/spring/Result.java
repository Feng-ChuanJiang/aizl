package org.lemonPig.os.assist.spring;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;


//@JsonIgnoreProperties(value = { "code" })  
public class Result {
	private String code;
	private boolean success;
	private Object data;
	private String[] messages;
	public Result() {
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String[] getMessages() {
		return messages;
	}
	public void setMessages(String[] messages) {
		this.messages = messages;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String toJson() throws IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}
	public static Result buildErrorResult(String... errors) {
		Result result= new Result();
		result.setSuccess(false);
		result.setMessages(errors);
		result.setCode("9999999999");
		return result;
	}
	public static Result buildSuccessResult(Object data,String... msg) {
		Result result=new Result();
		result.setSuccess(true);
		result.setMessages(msg);
		result.setData(data);
		return result;
	}
}

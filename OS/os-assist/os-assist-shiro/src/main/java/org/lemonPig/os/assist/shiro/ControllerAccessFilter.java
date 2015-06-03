package org.lemonPig.os.assist.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;

public class ControllerAccessFilter extends AccessControlFilter{
	private String controllerAccessFailAttrName;
	
	public String getControllerAccessFailAttrName() {
		return controllerAccessFailAttrName;
	}

	public void setControllerAccessFailAttrName(String controllerAccessFailAttrName) {
		this.controllerAccessFailAttrName = controllerAccessFailAttrName;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		request.setAttribute(controllerAccessFailAttrName, "该用户无权访问！");
		return true;
	}

}

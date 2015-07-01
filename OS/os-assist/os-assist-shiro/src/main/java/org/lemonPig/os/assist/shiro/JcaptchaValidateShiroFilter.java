package org.lemonPig.os.assist.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class JcaptchaValidateShiroFilter extends AccessControlFilter{
    private boolean jcaptchaEbabled = true;//是否开启验证码支持  
    private String jcaptchaParam = "jcaptcha";//前台提交的验证码参数名  
    private String jcaptchaFailAttributeName="jcaptchaFailMsg";
    public void setJcaptchaEbabled(boolean jcaptchaEbabled) {  
        this.jcaptchaEbabled = jcaptchaEbabled;  
    }  
    public void setJcaptchaParam(String jcaptchaParam) {  
        this.jcaptchaParam = jcaptchaParam;  
    } 
	
	public String getJcaptchaFailAttributeName() {
		return jcaptchaFailAttributeName;
	}
	public void setJcaptchaFailAttributeName(String jcaptchaFailAttributeName) {
		this.jcaptchaFailAttributeName = jcaptchaFailAttributeName;
	}
	public boolean isJcaptchaEbabled() {
		return jcaptchaEbabled;
	}
	public String getJcaptchaParam() {
		return jcaptchaParam;
	}
	@Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {  
  
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);  
        //2、判断验证码是否禁用 或不是表单提交（允许访问）  
        if (jcaptchaEbabled == false || !"post".equalsIgnoreCase(httpServletRequest.getMethod())) {  
            return true;
        }
        System.out.println(httpServletRequest.getSession().getAttribute("xxx"));
        boolean isRight= JCaptcha.validateResponse(httpServletRequest, httpServletRequest.getParameter(jcaptchaParam));  
        return isRight;
    }
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		request.setAttribute(jcaptchaFailAttributeName, "验证码错误");
		return true;
	}
	
}

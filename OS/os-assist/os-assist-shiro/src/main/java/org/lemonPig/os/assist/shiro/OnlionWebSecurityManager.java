package org.lemonPig.os.assist.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

public class OnlionWebSecurityManager extends DefaultWebSecurityManager{

	@Override
	public Subject login(Subject subject, AuthenticationToken token)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return super.login(subject, token);
	}

	@Override
	public void logout(Subject subject) {
		// TODO Auto-generated method stub
		super.logout(subject);
	}

	@Override
	protected void stopSession(Subject subject) {
		// TODO Auto-generated method stub
		super.stopSession(subject);
	}


	
	
}

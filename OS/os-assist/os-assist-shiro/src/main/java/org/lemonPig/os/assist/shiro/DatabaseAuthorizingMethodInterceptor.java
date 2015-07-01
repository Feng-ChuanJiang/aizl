package org.lemonPig.os.assist.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.shiro.aop.MethodInvocation;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.aop.AuthenticatedAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.AuthorizingMethodInterceptor;
import org.apache.shiro.authz.aop.GuestAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.PermissionAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.RoleAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.UserAnnotationMethodInterceptor;

public class DatabaseAuthorizingMethodInterceptor extends AuthorizingMethodInterceptor {
	

    protected Collection<AuthorizingAnnotationMethodInterceptor> methodInterceptors;

    public DatabaseAuthorizingMethodInterceptor() {
        methodInterceptors = new ArrayList<AuthorizingAnnotationMethodInterceptor>(5);
        methodInterceptors.add(new RoleAnnotationMethodInterceptor());
        methodInterceptors.add(new PermissionAnnotationMethodInterceptor());
        methodInterceptors.add(new AuthenticatedAnnotationMethodInterceptor());
        methodInterceptors.add(new UserAnnotationMethodInterceptor());
        methodInterceptors.add(new GuestAnnotationMethodInterceptor());
    }


    public Collection<AuthorizingAnnotationMethodInterceptor> getMethodInterceptors() {
        return methodInterceptors;
    }


    public void setMethodInterceptors(Collection<AuthorizingAnnotationMethodInterceptor> methodInterceptors) {
        this.methodInterceptors = methodInterceptors;
    }

   
    protected void assertAuthorized(MethodInvocation methodInvocation) throws AuthorizationException {
        Collection<AuthorizingAnnotationMethodInterceptor> aamis = getMethodInterceptors();
        if (aamis != null && !aamis.isEmpty()) {
            for (AuthorizingAnnotationMethodInterceptor aami : aamis) {
                if (aami.supports(methodInvocation)) {
                    aami.assertAuthorized(methodInvocation);
                }
            }
        }
    }

}

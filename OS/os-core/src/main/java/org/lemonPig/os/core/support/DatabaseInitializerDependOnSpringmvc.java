package org.lemonPig.os.core.support;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.Aware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


public class DatabaseInitializerDependOnSpringmvc implements ApplicationListener<ApplicationEvent> {
	AbstractHandlerMethodMapping<RequestMappingInfo> handlerMapping;
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
	}
	private Set<RequestMappingInfo> getMappedPath() {
		return handlerMapping.getHandlerMethods().keySet();
	}
	public AbstractHandlerMethodMapping<RequestMappingInfo> getHandlerMapping() {
		return handlerMapping;
	}
	public void setHandlerMapping(AbstractHandlerMethodMapping handlerMapping) {
		this.handlerMapping = handlerMapping;
	}
	
}

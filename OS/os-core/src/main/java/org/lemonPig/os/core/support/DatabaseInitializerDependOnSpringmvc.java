package org.lemonPig.os.core.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.lemonPig.os.assist.spring.HandlerMethodWrapper;
import org.lemonPig.os.assist.spring.SpringBeanUtil;
import org.lemonPig.os.common.BeanUtils;
import org.lemonPig.os.core.iservice.IResourceService;
import org.lemonPig.os.core.vo.Resource;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

public class DatabaseInitializerDependOnSpringmvc implements ApplicationListener<ContextRefreshedEvent> {
	AbstractHandlerMethodMapping<RequestMappingInfo> handlerMapping;
	private IResourceService iResourceService;
	private String databaseInitModel;
	public enum DatabaseInitModel {
		CREATE,UPDATE;
	}

	/**
	 * 获取springMVC所有的controller和uri映射关系
	 * @return
	 */
	public AbstractHandlerMethodMapping<RequestMappingInfo> getHandlerMapping() {
		return handlerMapping;
	}
	public void setHandlerMapping(AbstractHandlerMethodMapping<RequestMappingInfo> handlerMapping) {
		this.handlerMapping = handlerMapping;
	}
	public String getDatabaseInitModel() {
		return databaseInitModel;
	}
	public void setDatabaseInitModel(String databaseInitModel) {
		this.databaseInitModel = databaseInitModel;
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		iResourceService=SpringBeanUtil.getBean("iResourceService",IResourceService.class);
		Map<RequestMappingInfo, HandlerMethod> handlerMappings=handlerMapping.getHandlerMethods();
		if (DatabaseInitModel.CREATE.name().equals(databaseInitModel)) {
			//清空资源表
			iResourceService.deleteAll();
			//映射关系作为访问资源写入数据库
			Set<RequestMappingInfo> requestMappingInfoSet=handlerMappings.keySet();
			for (RequestMappingInfo requestMappingInfo : requestMappingInfoSet) {
				String requestMappingInfoJson=BeanUtils.writeToJson(requestMappingInfo);
				HandlerMethod handlerMethod=handlerMappings.get(requestMappingInfo);
				HandlerMethodWrapper handlerMethodWrapper=new HandlerMethodWrapper(handlerMethod);
				String handlerMethodJson=handlerMethodWrapper.toString();
				Resource resource=new Resource();
				resource.setRequestMappingInfo(requestMappingInfoJson);
				resource.setHandlermethod(handlerMethodJson);
				iResourceService.save(resource);
			}
		}else if (DatabaseInitModel.UPDATE.name().equals(databaseInitModel)) {
			Set<RequestMappingInfo> requestMappingInfoSet=handlerMappings.keySet();
			List<Resource> resources=new ArrayList<Resource>();
			for (RequestMappingInfo requestMappingInfo : requestMappingInfoSet) {
				String requestMappingInfoJson=BeanUtils.writeToJson(requestMappingInfo);
				HandlerMethod handlerMethod=handlerMappings.get(requestMappingInfo);
				HandlerMethodWrapper handlerMethodWrapper=new HandlerMethodWrapper(handlerMethod);
				String handlerMethodJson=handlerMethodWrapper.toString();
				Resource resource=new Resource();
				resource.setRequestMappingInfo(requestMappingInfoJson);
				resource.setHandlermethod(handlerMethodJson);
				iResourceService=SpringBeanUtil.getBean("iResourceService",IResourceService.class);
				resources.add(resource);
			}
			iResourceService.updateOrSaveByHandlerMethod(resources);
		}else {
			throw new RuntimeException("DatabaseInitializerDependOnSpringmvc only support databaseInitModel:create or update");
		}
	}
	
}

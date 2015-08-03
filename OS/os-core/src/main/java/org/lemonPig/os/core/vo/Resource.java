package org.lemonPig.os.core.vo;




public class Resource {
    private Long id;

    private Integer securityLevel;

    private String requestMappingInfo;

    private String handlermethod;
    
    private Long permissionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(Integer securityLevel) {
		this.securityLevel = securityLevel;
	}

	public String getRequestMappingInfo() {
		return requestMappingInfo;
	}

	public void setRequestMappingInfo(String requestMappingInfo) {
		this.requestMappingInfo = requestMappingInfo;
	}

	public String getHandlermethod() {
		return handlermethod;
	}

	public void setHandlermethod(String handlermethod) {
		this.handlermethod = handlermethod;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
    
	
}

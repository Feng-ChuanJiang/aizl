package org.lemonPig.os.assist.shiro;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

/**
 * 验证码缓存控制
 * @author Administrator
 *
 */
public class MyManageableImageCaptchaService extends DefaultManageableImageCaptchaService{
	public MyManageableImageCaptchaService(  
		      com.octo.captcha.service.captchastore.CaptchaStore captchaStore,        
		      com.octo.captcha.engine.CaptchaEngine captchaEngine,  
		      int minGuarantedStorageDelayInSeconds,   
		      int maxCaptchaStoreSize,   
		      int captchaStoreLoadBeforeGarbageCollection) {  
		        super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds,   
		            maxCaptchaStoreSize, captchaStoreLoadBeforeGarbageCollection);  
		    }  
		    public boolean hasCapcha(String id, String userCaptchaResponse) {  
		        return store.getCaptcha(id).validateResponse(userCaptchaResponse);  
		    }  
}

package org.lemonPig.os.assist.jcaptcha;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;

public class JCaptcha {
	//该处验证码可以用echcach代替fastHashMapCaptchaStore
	public static final MyManageableImageCaptchaService captchaService = new MyManageableImageCaptchaService(
			new FastHashMapCaptchaStore(), new GMailEngine(), 180, 100000,
			75000);
	/**
	 * 验证当前请求输入的验证码否正确；并从CaptchaService中删除已经生成的验证码；
	 * @param request
	 * @param userCaptchaResponse
	 * @return
	 */
	public static boolean validateResponse(HttpServletRequest request,
			String userCaptchaResponse) {
		if (request.getSession(false) == null)
			return false;
		boolean validated = false;
		try {
			String id = request.getSession().getId();
			validated = captchaService.validateResponseForID(id,
					userCaptchaResponse).booleanValue();
		} catch (CaptchaServiceException e) {
			//获取异常直接算做失败
//			e.printStackTrace();
		}
		return validated;
	}
	/**
	 * 验证当前请求输入的验证码是否正确；但不从CaptchaService中删除已经生成的验证码（比如Ajax验证时可以使用，防止多次生成验证码）
	 * @param request
	 * @param userCaptchaResponse
	 * @return
	 */
	public static boolean hasCaptcha(HttpServletRequest request,
			String userCaptchaResponse) {
		if (request.getSession(false) == null)
			return false;
		boolean validated = false;
		try {
			String id = request.getSession().getId();
			validated = captchaService.hasCapcha(id, userCaptchaResponse);
		} catch (CaptchaServiceException e) {
			e.printStackTrace();
		}
		return validated;
	}

	public static BufferedImage getCapachaImage(String sessionId) {
		return captchaService.getImageChallengeForID(sessionId);
	}
}

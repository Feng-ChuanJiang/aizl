package org.lemonPig.os.assist.shiro;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.servlet.OncePerRequestFilter;
import org.apache.shiro.web.util.WebUtils;

public class JcaptchaCreateShiroFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(ServletRequest request,
			ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest httpServletRequest=WebUtils.toHttp(request);
		HttpServletResponse httpServletResponse=WebUtils.toHttp(response);
		httpServletResponse.setDateHeader("Expires", 0L);
		httpServletResponse.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		httpServletResponse.addHeader("Cache-Control", "post-check=0, pre-check=0");
		httpServletResponse.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String id = httpServletRequest.getRequestedSessionId();
		BufferedImage bi = JCaptcha.getCapachaImage(id);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}

}

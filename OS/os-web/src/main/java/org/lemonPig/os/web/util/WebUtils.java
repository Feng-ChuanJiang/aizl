package org.lemonPig.os.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {
	public static void forwardToUri(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,String uri) throws ServletException, IOException {
		httpServletRequest.getRequestDispatcher(uri).forward(httpServletRequest, httpServletResponse);
	}
}

package org.lemonPig.os.assist.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DefaultExceptionHandler {
	private static final Logger logger = LoggerFactory
			.getLogger(DefaultExceptionHandler.class);

	/**
	 * 默认的统一异常处理异常
	 * <p/>
	 * 后续根据不同的需求定制即可
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ModelAndView processException(Exception e) {
		logger.error("系统执行异常", e);
		ModelAndView mv = new ModelAndView();
		Result result = Result.buildErrorResult("系统异常：" + e.getMessage());
		mv.addObject("error", result);
		mv.setViewName("error/exception");
		return mv;
	}

	@ExceptionHandler({ BizException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ModelAndView processRuntimeException(BizException e) {
		ModelAndView mv = new ModelAndView();
		Result result = Result.buildErrorResult(e.getMessage());
		mv.addObject("error", result);
		mv.setViewName("error/exception");
		return mv;
	}
}

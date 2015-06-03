package org.lemonPig.os.assist.spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DefaultExceptionHandler {

    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, Exception e) {
		return null;

//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error", exceptionResponse);
//        mv.setViewName("error/exception");
//
//        return mv;
    }

}

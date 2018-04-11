package net.jqsoft.ssm.util;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @desc 字符编码拦截器，设置统一编码为utf-8
 * utf-8编码也称之为万国码，它是一种变长的编码规则
 * 一个中文字符占三个字节
 * 一个英文字符所占的长度是一个字节
 * @author fangfq
 *	@date 2018年4月2日  
 */
public class EncodingIntercepter implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
			response.setCharacterEncoding("UTF-8");
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}

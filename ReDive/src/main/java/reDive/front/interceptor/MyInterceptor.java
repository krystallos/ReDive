package reDive.front.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion:执行成功之后");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle:执行过程");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// 判断是否执行对应的controller,如果return false 则不执行，反之执行
		System.out.println("preHandle:执行前");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}

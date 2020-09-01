package reDive.front.config;

import javax.annotation.Resource;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import reDive.front.interceptor.MyInterceptor;

public class InterceptorConfig implements WebMvcConfigurer {
	@Resource
	private MyInterceptor myInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
//		registry.addInterceptor(myInterceptor)
//			.addPathPatterns("/*.act") // 拦截所有的url
//			.excludePathPatterns("/login.lh"); // 但是hello的url不进行拦截
//		
//		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
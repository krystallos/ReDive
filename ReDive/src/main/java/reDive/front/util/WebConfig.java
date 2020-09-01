package reDive.front.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author 林瀚
 * 虚拟路径映射
 * 将虚拟FILE路径映射至本地目录D:/data0/file/下，使用方法http://localhost:8888/file/XXX.png
 *
 */
@Component
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/file/**").addResourceLocations("file:/data0/file/");  
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}

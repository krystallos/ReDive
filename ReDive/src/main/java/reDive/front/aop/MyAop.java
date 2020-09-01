package reDive.front.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component // 这个aop的类由spring来初始化
@Aspect // 并且将这个类设置监听，用来抓捕service方法
public class MyAop {
	/**
	 * 表达式的格式：
	 * execution(修饰符 返回值  包名.类名.方法名(参数类型))
	 * 注意：如果这个值随意则用 * 代替
	 * 注意：参数类型如果随意则用 .. 表示
	 * 	否则：java.lang.String, java.util.ArrayList 来设置参数
	 * 
	 * 
	 */
	@Before("execution(public * org.person.service.*.*(..))")
	public void before() {
	   System.out.println("before");
	} 
	
	
	@After("execution(public * org.person.service.*.*(..))")
	public void cstmAfter() {
		System.out.println("after");
	}
	
	private Logger log = Logger.getLogger(MyAop.class);
	
	@Around("execution(public * org.person.service.*.*(..))")
	public Object cstmAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("cstmAround before");
		System.out.println(pjp.getSignature().getName()); // 获取方法名
		System.out.println(pjp.getSignature().getDeclaringTypeName()); // 获取权限定名
		Object obj = null;
		try {
			// 执行service里面的方法，相当于filter过滤器中的放行doFilter()
			obj = pjp.proceed(); 
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			// 开始记录日志信息
			log.error(e.getMessage());
			throw e;
//			return null;
		}
		return obj;
	}
}

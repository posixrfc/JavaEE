package cn.itcast.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description: 拦截器2</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-15下午5:57:23
 * @version 1.0
 */
public class HandlerInterceptor2 implements HandlerInterceptor {

	//handler，springmvc根据url找到Handler(只有一个方法)
	//执行时机：进入Handler方法之前执行，如果返回false表示拦截，如果返回true表示放行
	//使用场景：用于用户身份校验，用户权限拦截校验
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("HandlerInterceptor2..preHandle");
		
		return false;
	}
	//执行时机：进入Handler方法之后 ，在返回modelAndView之前 
	//使用场景：使用modelAndView，向页面传递通用数据，使用统一的view
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor2..postHandle");
		
	}
	//执行时机：Handler方法执行完成，（modelAndView已经返回）
	//使用场景：统一异常处理，统一记录系统日志，用于action方法执行监控（在preHandle记录一个时间点，在afterCompletion记录执行结束时间点，将结束时间点减去开始执行时间点，得到执行时长）
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor2..afterCompletion");
		
	}

}

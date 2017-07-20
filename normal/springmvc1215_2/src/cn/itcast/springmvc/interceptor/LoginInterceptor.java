package cn.itcast.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description: 拦截器1</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-15下午5:57:23
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

	//handler，springmvc根据url找到Handler(只有一个方法)
	//执行时机：进入Handler方法之前执行，如果返回false表示拦截，如果返回true表示放行
	//使用场景：用于用户身份校验，用户权限拦截校验
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//判断请求的url是否公开 地址(无需登陆即可操作url)
		//正常开发时，需要将公开地址配置在配置文件中。
		//取出请求的url
		String url = request.getRequestURI();
		if(url.indexOf("loginsubmit.action")>=0){
			//说明 公开地址
			//放行
			return true;
		}
		
		
		//得到session
		HttpSession session = request.getSession();
		
		//从 session取出用户身份信息
		String userid = (String) session.getAttribute("activeUser");
		
		if(userid!=null){
			//说明 用户已登陆（用户身份合法）
			//放行
			return true;
			
		}
		
		//执行到这里说明 用户身份不合法，拦截，跳转到登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

		return false;
	}
	//执行时机：进入Handler方法之后 ，在返回modelAndView之前 
	//使用场景：使用modelAndView，向页面传递通用数据，使用统一的view
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	//执行时机：Handler方法执行完成，（modelAndView已经返回）
	//使用场景：统一异常处理，统一记录系统日志，用于action方法执行监控（在preHandle记录一个时间点，在afterCompletion记录执行结束时间点，将结束时间点减去开始执行时间点，得到执行时长）
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}

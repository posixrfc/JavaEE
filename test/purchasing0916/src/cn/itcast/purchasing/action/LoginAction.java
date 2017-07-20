package cn.itcast.purchasing.action;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.itcast.purchasing.service.UserService;
import cn.itcast.purchasing.util.UserUtil;
import cn.itcast.purchasing.vo.ActiveUser;

@Controller
public class LoginAction {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login()throws Exception{
		return "login";
	}
	
	@RequestMapping("/loginSubmit")
	public String loginSubmit(HttpSession session,String userId,String pwd)throws Exception{
		if(userId == null || userId.trim().equals(""))
			return "login";
		
		if(pwd == null || pwd.trim().equals(""))
			return "login";
		
		ActiveUser activeUser = userService.checkUser(userId, pwd);
		if(activeUser != null){
			UserUtil.saveUserToSession(session, activeUser);
			return "first";
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession)throws Exception{
		httpSession.invalidate();
		return "redirect:login.action";
	}	
}
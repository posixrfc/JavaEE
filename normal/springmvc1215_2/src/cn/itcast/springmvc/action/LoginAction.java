package cn.itcast.springmvc.action;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction {
	
	//登陆页面
	@RequestMapping("/login")
	public String login(Model model)throws Exception{
		
		return "login";
	}
	
	//登陆提交
	//userid：用户账号，pwd：密码
	@RequestMapping("/loginsubmit")
	public String loginsubmit(HttpSession session,String userid,String pwd)throws Exception{
		
		//向session记录用户身份信息
		session.setAttribute("activeUser", userid);
		
		return "redirect:stu/querystudent.action";
	}
	
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:stu/querystudent.action";
	}
}
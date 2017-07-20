package cn.itcast.bean.team;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TeamApp {
	public static void main(String[] args) {
		//导入单个配置文件，然后配置文件中import其他的配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-user.xml");
		//导入多个配置文件
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-user.xml","applicationContext.xml");
		Team2 bean = (Team2) ctx.getBean("team2");
		bean.test();
	}
}


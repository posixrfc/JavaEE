package com.atguigu.i18n;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.Test;
public class TestI18N {
	@Test
	public void test3(){	
		Locale locale = Locale.CHINA;
		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, locale);
		String date = format.format(new Date());
		System.out.println(date);	
	}
	@Test
	public void test2(){
		Locale locale = Locale.KOREA;
		ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		String login = bundle.getString("login");
		System.out.println(username+"--"+password+"--"+login);
	}
	
	@Test
	public void test1() {
		Locale locale = Locale.CHINA;
		locale = Locale.getDefault();
		locale = new Locale("zh", "CN");
		System.out.println(locale);
	}
}
package cn.itcast.javamail2;

import java.io.FileInputStream;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo2 {
	public static void main(String[] args) throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.sina.com");
		Session session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("wcy658099","wcy123456");
					}
				});
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("itcast_xxx@sina.com"));
		msg.setSubject("sbt");
		msg.setRecipients(RecipientType.TO, 
				InternetAddress.parse("nhy910108@sohu.com,1770750695@qq.com"));
		msg.setContent("<span style='color:red'>china</span>", "text/html;charset=gbk");
		Transport.send(msg);
//		Message msg = new MimeMessage(session,new FileInputStream("resouce\\demo3.eml"));
//		Transport.send(msg,InternetAddress.parse("itcast_test@sohu.com"));
	}
}
package cn.itcast.javamail2;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo1 {
	public static void main(String[] args) throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		Message msg = new MimeMessage(session);
		msg.setText("Howyouare");
		msg.setFrom(new InternetAddress("lili@sohu.com"));
	
		Transport transport = session.getTransport();
		transport.connect("smtp.sina.com", 25, "wcy658099", "wcy123456");
		transport.sendMessage(msg,new Address[]{new InternetAddress("nhy910108@sohu.com")});
		transport.close();
	}
}
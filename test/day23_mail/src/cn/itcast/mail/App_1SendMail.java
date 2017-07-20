package cn.itcast.mail;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;
public class App_1SendMail {
	@Test
	public void testSend() throws Exception {
		Properties prop = new Properties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.host", "smtp.qq.com");
		prop.put("mail.smtp.port", 25);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.debug", "true");
		Session session = Session.getDefaultInstance(prop);
		MimeMessage message = new MimeMessage(session);
		message.setSubject("sbjt");
		message.setSentDate(new Date());
		message.setSender(new InternetAddress("1770750695@qq.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress("wcy658099@sina.com"));
		message.setContent("<a href='http://www.baidu.com'>bd</a>", "text/html;charset=UTF-8");
		message.saveChanges();
//		message.writeTo(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\a.eml"));
		Transport trans = session.getTransport();
		trans.connect("1770750695", "msdnc&%ppt");
		trans.sendMessage(message, message.getAllRecipients());
		trans.close();
	}
}
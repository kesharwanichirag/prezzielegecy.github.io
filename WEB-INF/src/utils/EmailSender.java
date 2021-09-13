package utils;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Message.RecipientType;
import javax.mail.Transport;
import javax.mail.MessagingException;

public class EmailSender{
	public static void sendEmail(String email, String subject,String msg,String senderEmail,String senderEmailPassword){
		Properties properties = new Properties();
		
		properties.put("mail.transport.protocol","smtp");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.starttls.enable","true");

		Session emailSession = Session.getInstance(properties,new MyPasswordAuthenticator());
		
		MimeMessage message = new MimeMessage(emailSession);

		try{
			message.setFrom(senderEmail);
			message.setRecipients(Message.RecipientType.TO,email);
			message.setSubject(subject);
			message.setContent(msg,"text/html");

			Transport.send(message);

		}catch(MessagingException e){
			e.printStackTrace();
		}
	}
}

class MyPasswordAuthenticator extends Authenticator{

	public PasswordAuthentication getPasswordAuthentication(){

		return new PasswordAuthentication("legecyprezzie@gmail.com","PrezzieLegecy@1");
	}
}
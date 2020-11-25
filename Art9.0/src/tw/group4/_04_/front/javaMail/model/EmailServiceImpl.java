package tw.group4._04_.front.javaMail.model;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl  {
	
	//注入JavaMailSender
    @Autowired
    private JavaMailSender emailSender;
    
    //簡單mail寄送
    public void sendSimpleMessage(
      String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("noreply@baeldung.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }
    
    //含附件mail寄送
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException  {
        
        MimeMessage message = emailSender.createMimeMessage();
         
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setFrom("noreply@baeldung.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
            
        FileSystemResource file 
          = new FileSystemResource(new File(pathToAttachment));
        //
        helper.addAttachment("Invoice.jpg", file);
     
        emailSender.send(message);

    }
}
package tw.group4._04_.front.javaMail.controller;

import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.group4._04_.front.javaMail.model.EmailServiceImpl;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanService;

@Controller
public class SpringMail {

	@Autowired
	private EmailServiceImpl emailServiceImpl;

	@RequestMapping(path = "/04/mailsend.ctrl", method = RequestMethod.GET)
	public String processmailsend(String category, String page, Model model) {
		
		String to = "benny199312@gmail.com";
		String subject = "SpringMAIL";
		String text = "TEST!!TEST!!";
		emailServiceImpl.sendSimpleMessage(to, subject, text);
		System.out.println("mail已寄送");
			return "AAA";
	}
	
	@RequestMapping(path = "/04/mailsendAttituate.ctrl", method = RequestMethod.GET)
	public String processmailsendAttituate(String category, String page, Model model) throws MessagingException {
		
		String to = "benny199312@gmail.com";
		String subject = "SpringMAIL";
		String text = "TEST!!TEST!!";
		String pathToAttachment = "C:\\Users\\Student\\source\\Downloads\\p5.jpg";
		
		emailServiceImpl.sendMessageWithAttachment(to, subject, text, pathToAttachment);
		System.out.println("mail已寄送");
			return "AAA";
	}
}


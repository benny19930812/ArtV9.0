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

import tw.group4._04_.front.shopcart.model.Shoppingcart;

@Service
public class EmailServiceImpl {

	// 注入JavaMailSender
	@Autowired
	private JavaMailSender emailSender;
	@Autowired
	private EmailServiceImpl emailServiceImpl;

	// 簡單mail寄送
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@baeldung.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	// 含附件mail寄送
	public void sendMessageWithAttachment(String to, String subject, String text)
//	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment)
			throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom("noreply@baeldung.com");
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text, true);
		
//		FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
		//
//		helper.addAttachment("Invoice.jpg", file);

		emailSender.send(message);

	}

	public  void processmailsendAttituate(Shoppingcart shoppingcart) throws MessagingException {
		
		//寄訂單詳細mail
		String to =  shoppingcart.getEMAIL();
		String subject = "訂單編號"+shoppingcart.getORDERID()+"購物詳細";
		String text = "親愛的"+shoppingcart.getNAME()+"先生／小姐，您好!"+"\n\r"
							+ "感謝您於得藝的一天購物。"+"\n\r"
							+ "訂單編號："+shoppingcart.getORDERID()+"\n\r"
							+ "訂購人姓名："+shoppingcart.getNAME()+"\n\r"
							+ "電子郵件："+shoppingcart.getEMAIL()+"\n\r"
							+ "電話："+shoppingcart.getTEL()+"\n\r"
							+ "地址："+shoppingcart.getADDRESS()+"\n\r"
							+ "節目名稱："+shoppingcart.getTITLE()+"\n\r"
							+ "票種："+shoppingcart.getTICKETCATEGORY()+"\n\r"
							+ "數量："+shoppingcart.getTICKET_NUM()+"\n\r"
							+ "座位編號："+shoppingcart.getSeatstring()+"\n\r"
							+ "總金額：NT$"+shoppingcart.getTOTALPRICE();
		
		String pathToAttachment = "QRcodeOutput/QRCode.png";	
		emailServiceImpl.sendSimpleMessage(to, subject, text);
		System.out.println("mail已寄送");
	}
	
	public  void processmailsendHTML(Shoppingcart shoppingcart) throws MessagingException {
		
		//寄訂單詳細mail
		String to =  shoppingcart.getEMAIL();
		String subject = "訂單編號"+shoppingcart.getORDERID()+"購物詳細";
		String text = 
				"\r\n" + 
				"<!DOCTYPE html>\r\n" + 
				"<html lang=\"zh-tw\">\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>訂單</title>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"form{\r\n" + 
				"display:inline;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <p>親愛的"+shoppingcart.getNAME()+"先生／小姐，您好!</p>\r\n" + 
				"    <p>感謝您於得藝的一天購物。</p>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" <br><br><H1>訂購人資訊</H1>\r\n" + 
				"    <table class= \"table table-bordered\">\r\n" + 
				"        <tr>\r\n" + 
				"            <td>訂單編號\r\n" + 
				"            </td>\r\n" + 
				"            <td>"+shoppingcart.getORDERID()+"</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>訂購人姓名\r\n" + 
				"            </td>\r\n" + 
				"            <td>"+shoppingcart.getNAME()+"</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>電子郵件\r\n" + 
				"            </td>\r\n" + 
				"            <td>"+shoppingcart.getEMAIL()+"</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>電話\r\n" + 
				"            </td>\r\n" + 
				"            <td>"+shoppingcart.getTEL()+"</td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td>地址\r\n" + 
				"            </td>\r\n" + 
				"            <td>"+shoppingcart.getADDRESS()+"</td>\r\n" + 
				"        </tr>\r\n" + 
				"     </table><br><br> <br>  \r\n" + 
				"     \r\n" + 
				"	<H2>票券資訊</H2>\r\n" + 
				"		<table class=\"table table-bordered\">\r\n" + 
				"		<tr> \r\n" + 
				"				<td>節目名稱</td>\r\n" + 
				"				<td>票種</td>\r\n" + 
				"				<td>座位</td>\r\n" + 
				"				<td>票價</td>\r\n" + 
				"\r\n" + 
				"			</tr>\r\n" + 
				"		\r\n" + 
				"			<tr> \r\n" + 
				"				<td class=\"title\">shoppingcart.getTITLE()</td>\r\n" + 
				"				<td >"+shoppingcart.getTICKETCATEGORY()+"</td>\r\n" + 
				"				<td >"+shoppingcart.getSeatstring()+"</td>\r\n" + 
				"				<td class=\"price\"></td>\r\n" + 
				"				\r\n" + 
				"			</tr>\r\n" + 
				"			\r\n" + 
				"			<tr> \r\n" + 
				"				<td >總計:</td>\r\n" + 
				"				<td ></td>\r\n" + 
				"				<td ></td>\r\n" + 
				"				<td >NT$"+shoppingcart.getTOTALPRICE()+"</td>\r\n" + 
				"			\r\n" + 
				"			</tr>\r\n" + 
				"			\r\n" + 
				"		</table>	\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>";
				
			
				
		String pathToAttachment = "./QRcodeOutput/QRCode.png";	
		emailServiceImpl.sendMessageWithAttachment(to, subject, text);
		System.out.println("mail已寄送");
	}
}
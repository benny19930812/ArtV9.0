package tw.group4._04_.front.javaMail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SimpleJavaMailSend {
 public static void main(String args[]) {
  String host = "smtp.gmail.com";
  int port = 587;
  final String username = "u9913036@gms.ndhu.edu.tw";
  final String password = "benny19930812";//your password

  Properties props = new Properties();
  props.put("mail.smtp.host", host);
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.port", port);
  Session session = Session.getInstance(props, new Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
   }
  });

  try {

   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress("u9913036@gms.ndhu.edu.tw"));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("benny199312@hotmail.com"));
   message.setSubject("測試寄信.");
   message.setText("Dear BinBin, \n\n 測試 測試 測試 測試 測試 測試 java email !");

   Transport transport = session.getTransport("smtp");
   transport.connect(host, port, username, password);

   Transport.send(message);

   System.out.println("寄送email結束.");

  } catch (MessagingException e) {
   throw new RuntimeException(e);
  }
 }
}

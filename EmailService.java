
package com.linkcode.vehicleRentalSystem;

import java.time.LocalDate;
import java.util.Properties;

import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;
//import javax.mail.*;
//import javax.mail.internet.*;

public class EmailService {

    public static String sendBookingConfirmation(Customer cust, Vehicle vehicle, double amount) {

        String subject = "Vehicle Rental Confirmation";

        String body = "Respected " + cust.getName() + ",\n"
                + "Vehicle Id: " + vehicle.getVehicleId() + "\n"
                + "Total Bill: " + amount + "\n"
                + "Paid Amount: " + amount + "\n"
                + "No of Days: " + vehicle.getRentedDays() + "\n"
                + "Start Date: " + LocalDate.now() + "\n";

        System.out.println("Sending mail to " + cust.getEmail());

        // Sender credentials
        final String senderMail = "your_email@gmail.com";
        final String senderPass = "your_app_password";

        // SMTP configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create session
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, senderPass);
            }
        });

        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(cust.getEmail()));
            message.setSubject(subject);
            message.setText(body);

            // Send email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return body;
    }
}







//package com.linkcode.vehicleRentalSystem;
//
//import java.time.LocalDate;
//
//import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;
//
//public class EmailService {
//	
//	public static String sendBookingConfirmation(Customer cust, Vehicle vehicle,double amount);
//		
//		String sub="Vehicle rental Confirmation";
//		
//		String data="Respected"+cust.getName()+",\n"
//		+"Vehicle Id :"+vehicle.getVehicleId()+",\n"
//		+"Total Bill :"+amount+",\n"
//		+"Paid Amount:"+amount+",\n"
//		+"No of Days :"+vehicle.getRentedDays()+",\n"
//		+"Day Start From :"+LocalDate.now()+",\n";
//		
//		System.out.println("sending main to "+cust.getEmail());
//			try {
//				Thread.sleep(5000);
//			}catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			return data;
//			 set properties 
//			 Properties properties =new Properties();
//			 properties.put("mail.smtp.auth", "true");
//			 properties.put("mail.smtp.starttls.enable", "true");
//			 properties.put("mail.smtp.host", "smtp.gmail.com");
//			 properties.put("mail.smtp.port", "587");
//			// intialize inbuilt mail sender classes 
//			 Session session=Session.getInstance(properties,new Authenticator() {
//			 @Override
//			 protected PasswordAuthentication getPasswordAuthentication() {
//			 return new PasswordAuthentication(senderMail, senderPass);
//			 }
//			 });
//			// actual mail send 
//			 Message message =new MimeMessage(session);
//			 try {
//			 message.setFrom(new InternetAddress(senderMail));
//			 message.setRecipient(Message.RecipientType.TO, new InternetAddress(cust.getEmail()));
//			 message.setSubject(title);
//			 message.setText(body);
//			 //Send the Mail
//			 Transport.send(message);
//			 System.out.println("Email send to"+cust.getEmail());
//			 } catch (AddressException e) {
//			 // TODO Auto-generated catch block
//			 e.printStackTrace();
//			 } catch (MessagingException e) {
//			 // TODO Auto-generated catch block
//			 e.printStackTrace();
//			 }
//}

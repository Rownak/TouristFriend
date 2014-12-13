/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.useful;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Rownak
 */
public class SendMail {

    public static void sendMail(String toAddress, int idUser) throws MessagingException {
        
        String username = "sajjadrownak@gmail.com";
        String userpass = "201033101826";
        //String toAddress = "rownak.sust@gmail.com";
        
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.auth", "true");
        
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, userpass);
            }
        };
        
        Session session = Session.getInstance(props, auth);
        
        Message msg = new MimeMessage(session);
        
            msg.setSubject("Validation");
            msg.setText("http://192.168.2.110:8084/TouristFriend_BackEnd/ValidateUser?idUser=" +idUser);

            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

            Transport.send(msg);
        
        System.out.println("Finished..");
    }

}
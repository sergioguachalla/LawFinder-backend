package com.lawfinder.backend.services;

import com.lawfinder.backend.dao.UserRepository;
import com.lawfinder.backend.dao.UserRoleRepository;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component

public class EmailService {


    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Value("${spring.mail.username}")
    private String FROM;


    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

         message.setTo(to);
         message.setSubject(subject);
         message.setText(text);
         mailSender.send(message);
    }

    public void sendEmailMime(String to, String subject, String text) {
        MimeMessage message = createMimeMessage(to, subject, text);
        mailSender.send(message);
    }

    private MimeMessage createMimeMessage(String to,String subject,String body) {
        var message = mailSender.createMimeMessage();
        try {
            message.setFrom(new InternetAddress(FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;

    }
}


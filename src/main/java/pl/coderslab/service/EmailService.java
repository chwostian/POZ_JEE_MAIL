package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.coderslab.model.EmailMessage;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;
    private String defaultMailFrom;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, String defaultMailFrom) {
        this.javaMailSender = javaMailSender;
        this.defaultMailFrom = defaultMailFrom;
    }

    public void send(EmailMessage emailMessage) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(defaultMailFrom);
        simpleMailMessage.setTo(emailMessage.getRecipient());
        simpleMailMessage.setSubject(emailMessage.getSubject());
        simpleMailMessage.setText(emailMessage.getBody());
        javaMailSender.send(simpleMailMessage);
    }

}

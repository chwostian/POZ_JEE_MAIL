package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.EmailMessage;
import pl.coderslab.service.EmailService;

@Controller
class EmailController {

    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    private String prepareEmail() {
        return "prepareEmail";
    }

    @PostMapping
    private String sendEmail(EmailMessage emailMessage) {
        emailService.send(emailMessage);
        return "prepareEmail";
    }

}

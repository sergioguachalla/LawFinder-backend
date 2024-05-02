package com.lawfinder.backend.api;

import com.lawfinder.backend.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class TestEmail {
    @Autowired
    EmailService emailService;

    @PostMapping("/")
    public String sendEmail(@RequestParam()String to, @RequestParam String subject, @RequestParam String body) {
        this.emailService.sendEmailMime(
                to,
                subject,
                body
        );
        return "Email sent";
    }

}

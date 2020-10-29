package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleMail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("615332135@qq.com");
            message.setSubject("一个简单的邮件");
            message.setText("使用Spring Boot发送的邮件。");
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

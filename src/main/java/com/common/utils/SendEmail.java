package com.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * Created by 黎 on 2017/12/4.
 */
@Component
public class SendEmail {

    @Autowired
    private JavaMailSenderImpl email;

    public Boolean sendEmail(String to,String content,String title){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("13755682283@163.com");//发件人
            message.setTo(to);//收件人
            message.setSubject(title);
            message.setText(content);
            email.send(message);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}

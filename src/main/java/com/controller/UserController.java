package com.controller;


import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 123 on 2017/11/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSenderImpl email;

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(){
        System.out.println("aaa");
        System.out.println(userService.getUserById(1).getUserName());
        //userService.updateUserMoney(1,5555);
        return "aaa";
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public  String sendEmail(String from,String to,String title,String content){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);//发件人
            message.setTo(to);//收件人
            message.setSubject(title);
            message.setText(content);
            email.send(message);
            System.out.println("ok");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return "ok";
    }
    @RequestMapping("getImage")
    public void getImage(HttpServletRequest request, HttpServletResponse response){

    }
}

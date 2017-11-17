package com.controller;


import com.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(){
        System.out.println(userService.getUserById(1).get(0).getUserName());
        System.out.println("aaa");
        return "aaa";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file,@RequestParam("name") String name){
        if(file.isEmpty()){
            return "文件不能为空";
        }
        System.out.println(name);
        try {
            file.transferTo(new File("d:/" + file.getOriginalFilename()));
            System.out.println(file.getOriginalFilename());
        } catch (IOException e) {
            return "ccc";
        }
        return "bbb";
    }

    @RequestMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(@RequestParam(name = "test", defaultValue = "false", required = false) Boolean test){
        if(null != test){
            System.out.println(test);
            if(test){
                System.out.println("boolean true");
            }else{
                System.out.println("boolean false");
            }
        }else{
            System.out.println("null");
        }
        return "sss";
    }

}

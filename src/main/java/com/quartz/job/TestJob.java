package com.quartz.job;

import com.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by 黎 on 2017/11/20.
 */
@Component
public class TestJob  {

    @Autowired
    private UserService userService;

    public void execute(){
        System.out.println(new Date());
        System.out.println(userService.getUserById(1).getUserName());


    }
}

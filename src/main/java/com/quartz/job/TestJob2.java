package com.quartz.job;

import com.service.UserService;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by 黎 on 2017/11/20.
 */
public class TestJob2 extends BaseJob {
    @Autowired
    private UserService userService;

    public void execute(JobExecutionContext context){
        System.out.println(new Date());
        System.out.println(userService.getUserById(1).getUserName());
    }
}

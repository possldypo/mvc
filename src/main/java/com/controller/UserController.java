package com.controller;


import com.common.ResultData;
import com.common.utils.MD5;
import com.common.utils.SendEmail;
import com.entity.TRetrievedPassword;
import com.entity.TUser;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by 123 on 2017/11/15.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("register")
    public ResultData register(@Valid TUser user, BindingResult bindingResult){
        ResultData resultData = new ResultData();
        if(bindingResult.hasErrors()){
            resultData.setCode(ResultData.CODE_FAILED);
        }else if(null != userService.selectTUser(user.getEmail())){
            resultData.setCode(ResultData.CODE_FAILED);
            resultData.setMsg("该邮箱已注册");
        }else{
            try {
                user.setPassword(MD5.createPasswordMD5(user.getPassword()));
            } catch (Exception e) {
                resultData.setMsg(ResultData.MSG_FAILED);
                resultData.setCode(ResultData.CODE_FAILED);
                return resultData;
            }
            userService.insertTUser(user);
            resultData.setCode(ResultData.CODE_SUCCESS);
            resultData.setMsg(ResultData.MSG_SUCCESS);
        }
        return resultData;
    }
    @RequestMapping("retrievedPassword")
    public ResultData resetPassword(@RequestParam String eMail,@RequestParam String password){
        ResultData resultData = new ResultData();
        TUser tUser = userService.selectTUser(eMail);
        if(null == tUser){
            resultData.setCode(ResultData.CODE_FAILED);
            resultData.setMsg("重置失败");
            return resultData;
        }
        try {
            userService.insertRetrieved(eMail,password);
            String secretKey = MD5.getMD5(tUser.getId().toString()+tUser.getCreateTime().toString()+eMail);
            String url = "http://localhost/user/validator?email=" + eMail + "&valid=" + secretKey;
            if(new SendEmail().sendEmail(eMail,url,"密码重置")){
                resultData.setMsg(ResultData.MSG_SUCCESS);
                resultData.setCode(ResultData.CODE_SUCCESS);
            }
        } catch (Exception e) {
            resultData.setMsg(ResultData.MSG_FAILED);
            resultData.setCode(ResultData.CODE_FAILED);
        }
        return resultData;
    }
    @RequestMapping("login")
    public ResultData login(@RequestParam String eMail, @RequestParam String password
            , HttpServletRequest httpServletRequest,HttpSession session){
        ResultData resultData = new ResultData();
        TUser user = userService.selectTUser(eMail);
        try{
            if(null == user || MD5.createPasswordMD5(password).equals(user.getPassword())) {
                resultData.setCode(ResultData.CODE_FAILED);
                resultData.setMsg("账号或密码错误");
            }else{
                resultData.setCode(ResultData.CODE_SUCCESS);
                resultData.setMsg(ResultData.MSG_FAILED);
                session.setAttribute("userName",user.getUserName());
                session.setAttribute("eMail",user.getEmail());
            }
        }catch (Exception e){
            resultData.setMsg(ResultData.MSG_FAILED);
            resultData.setCode(ResultData.CODE_FAILED);
        }
        return resultData;
    }
    @RequestMapping("validator")
    public ResultData validator(String email,String valid){
        ResultData resultData = new ResultData();
        TRetrievedPassword tRetrievedPassword = userService.selectRPByEmail(email);
        if(null != tRetrievedPassword){
            TUser tUser = userService.selectTUser(email);
            try {
                if(MD5.getMD5(tUser.getId().toString()+tUser.getCreateTime().toString()+email).equals(valid)){
                    tRetrievedPassword.getLastUpdateTime();
                    userService.updatePassword(tUser.getEmail(),tUser.getId(),tRetrievedPassword.getPassword());
                    resultData.setCode(ResultData.CODE_SUCCESS);
                    resultData.setMsg(ResultData.MSG_FAILED);
                }
            } catch (Exception e) {
                resultData.setMsg(ResultData.MSG_FAILED);
                resultData.setCode(ResultData.CODE_FAILED);
            }
        }
        return resultData;
    }
}

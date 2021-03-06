package com.service.impl;

import com.dao.MoneyDao;
import com.dao.TRetrievedPasswordMapper;
import com.dao.TUserMapper;
import com.dao.UserDao;
import com.entity.TRetrievedPassword;
import com.entity.TUser;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private MoneyDao moneyDao;

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private TRetrievedPasswordMapper tRetrievedPasswordMapper;

    @Transactional
    public User getUserById(Integer id) {
        return userDao.getUser(1);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE,readOnly = false,
            timeout = 5,rollbackFor = java.lang.Exception.class,noRollbackFor = java.lang.NullPointerException.class)
    public void updateUserMoney(Integer userId, Integer addMoney){
        System.out.println("in");
        Integer userMoney = moneyDao.getUserMoney(userId);
        System.out.println(userMoney);
        if(null == userMoney){
            System.out.println("null");
            Integer money = addMoney < 0 ? 0 : addMoney;
            moneyDao.insertUserMoney(userId,money);
            System.out.println("over");
        }else{
            System.out.println("get");
            moneyDao.updateUserMoney(userId,userMoney+addMoney);
        }
        Integer nullData = null;
        System.out.println(nullData+1);
    }

    public void insertTUser(TUser user) {
        tUserMapper.insert(user);
    }

    public TUser selectTUser(String eMail){
        return tUserMapper.selectByEmail(eMail);
    }

    @Override
    public void insertRetrieved(String email,String password){}

    @Override
    public TRetrievedPassword selectRPByEmail(String email) {
        return tRetrievedPasswordMapper.selectByEmail(email);
    }
    @Override
    public void updatePassword(String email,Integer id,String password){
        if(null != id){
            tUserMapper.updatePasswordById(password,id);
        }else if(null != email){
            tUserMapper.updatePasswordByEmail(password,email);
        }
    }
}

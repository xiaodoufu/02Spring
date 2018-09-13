package com.xdf.service;

import com.xdf.dao.UserDao;

public class UserServiceImpl implements UserService {

    //书写dao层对象
    private UserDao dao;




    @Override
    public String eat() {
        //System.out.println("进入了serviceImpl中的eat"+(5/0));  //出现异常
        System.out.println("进入了serviceImpl中的eat");  //出现异常
        String result=dao.eat(); //主业务
        return result;
    }

    @Override
    public void sleep() {
        dao.sleep();
    }

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}

package com.xdf.dao;

public class UserDaoImpl implements UserDao {

    @Override
    public String eat() {
        System.out.println("晓圆在吃。。。。。");
        return "面包";
    }

    @Override
    public void sleep() {
        System.out.println("睡觉......");
    }
}

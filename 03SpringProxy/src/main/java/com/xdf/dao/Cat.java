package com.xdf.dao;

/**
 * 动物的实现类
 */
public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("吃鱼==》主业务");
    }
}

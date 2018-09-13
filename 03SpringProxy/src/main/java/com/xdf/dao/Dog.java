package com.xdf.dao;

/**
 * 动物的实现类
 */
public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("吃骨头==》主业务");
    }
}

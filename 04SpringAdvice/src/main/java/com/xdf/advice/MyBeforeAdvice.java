package com.xdf.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置通知类
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    /**
     * @param method   需要增强的方法
     * @param args     方法的参数
     * @param target   目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("进入了前置通知======================================");
       // System.out.println("method===>"+method.getName());
      //  System.out.println("target===>"+target.getClass().getSimpleName());
    }
}

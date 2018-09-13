package com.xdf.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置通知
 */
public class MyAfterAdvice  implements AfterReturningAdvice{
    /**
     *
     * @param returnValue   主业务的返回值
     * @param method    主业务方法
     * @param args      主业务方法参数
     * @param target    目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了后置通知======================================");
       // System.out.println("主业务的返回值=====》"+returnValue);
        // returnValue="土豆";  没有意义
    }
}

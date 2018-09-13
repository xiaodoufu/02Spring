package com.xdf.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强
 */
public class MyAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("进入了环绕增强1========================");
        Object result = methodInvocation.proceed();//执行主业务方法
        System.out.println("进入了环绕增强2========================");
        result="土豆";  //更改方法的返回值 会生效
        return result;
    }
}

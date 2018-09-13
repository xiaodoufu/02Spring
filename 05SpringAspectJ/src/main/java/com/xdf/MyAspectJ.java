package com.xdf;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 切面类  系统级业务
 */
@Aspect
public class MyAspectJ {

   @Before("execution(* *..service..*.sleep())")
    public  void before(){
        System.out.println("洗洗手");
    }

}



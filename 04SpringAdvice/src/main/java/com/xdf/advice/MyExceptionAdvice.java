package com.xdf.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * 异常通知
 */
public class MyExceptionAdvice  implements ThrowsAdvice{

     public void afterThrowing(Exception ex){
         System.out.println("进入了 异常通知==========================");
         System.out.println("异常信息为======》"+ex.getMessage());
     }


}

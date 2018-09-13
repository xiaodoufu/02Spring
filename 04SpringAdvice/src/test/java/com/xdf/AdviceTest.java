package com.xdf;

import com.xdf.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceTest {
    ApplicationContext context=null;
    @Before
    public void before(){

       // context=new ClassPathXmlApplicationContext("Spring-advice.xml");
        //context=new ClassPathXmlApplicationContext("Spring-advisor.xml");
        context=new ClassPathXmlApplicationContext("Spring-proxy.xml");
    }

    @Test
    public void testBefore(){
        //首先 按照我们之前的逻辑去访问service
      // UserService service= (UserService) context.getBean("userServiceImpl");
        //目前阶段必须获取工厂 因为工厂让通知和目标产生了关系
       UserService service= (UserService) context.getBean("userProxyFactory");
      // String result=service.eat();
        service.sleep();
    }


    @Test
    public void testBefore2(){
       UserService service= (UserService) context.getBean("userServiceImpl2");
        service.eat();
    }




}

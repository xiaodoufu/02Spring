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
        context=new ClassPathXmlApplicationContext("Spring-aspectj2.xml");
    }

    @Test
    public void testBefore(){
       UserService service= (UserService) context.getBean("userServiceImpl");
        service.eat();
    }





}

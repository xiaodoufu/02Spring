package com.xdf;

import static org.junit.Assert.assertTrue;

import com.xdf.service.BuyStock;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void  buyStock(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring-transaction.xml");
        BuyStock stock = context.getBean(BuyStock.class);
        try {
            stock.buyStock("张三",1000,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

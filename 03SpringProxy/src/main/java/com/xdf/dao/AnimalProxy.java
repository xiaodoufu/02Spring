package com.xdf.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 *  实现接口
 *  AnimalProxy 代理类
 */
public class AnimalProxy implements InvocationHandler {

    /**
     * 01.创建委托类对象
     * 02.不知道委托类的类型
     */
    private Object  object;

    /**
     * 01.需要别人给我们传递一个委托类target
     * 02.返回一个代理对象
     */
    public Object  createProxy(Object  target){
        object=target;  //确定了委托类类型
       return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this) ;
    }

    /**
     * 真正做增强的方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("洗洗手===》系统级业务（增强业务）");
        Object result= method.invoke(object,args); //真正执行主业务
        return result;
    }

    public static void main(String[] args) {
         //创建对象
        AnimalProxy proxy=new AnimalProxy();
        //获取代理类对象
       Animal dog= (Animal) proxy.createProxy(new Cat());
       dog.eat();  //会进入invoke
    }
}

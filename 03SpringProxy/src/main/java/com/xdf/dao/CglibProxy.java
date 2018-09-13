package com.xdf.dao;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer=new Enhancer();

    /**
     * 根据用户传递的委托类  返回一个代理类
     */
    public  Object createProxy(Class clazz){
        //设置公共的父类或者是接口
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return  enhancer.create();
    }


    /**
     * @param o  委托类
     * @param method  方法
     * @param objects 方法参宿
     * @param methodProxy  方法代理
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("洗洗手===》系统级业务（增强业务）");
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }


    public static void main(String[] args) {
        //创建对象
        CglibProxy proxy=new CglibProxy();
        //获取代理类对象
        Animal dog= (Animal) proxy.createProxy(Cat.class);
        dog.eat();  //会进入invoke
    }
}

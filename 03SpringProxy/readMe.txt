根据代理类创建时机的不同可以为两种方式：
01.静态代理
    在程序运行之前，以及确定了代理类对象
    UserDao    UserServiceImpl
02.动态代理
    在程序运行期间，通过反射的方式动态获取代理类对象
    UserServiceImpl
      private  UserDao  dao;
      <bean id="userService" class="">
        <property name="dao" ref="userDao"/>
      </bean>

代理设计模式的特点：
   01.具有代理类和委托类
   02.务必有共同的接口或者父类
   03.代理类和委托类存在关系
   04.一个代理类对应一个委托类对象
   05.功能真正的实现着是委托类


例子：
  小黑  找   小白 送花 给 小强！

小黑：委托人
小白: 代理人
送花: 主业务

interface  送花{
    送花();
}

小黑  implements 送花{   委托类
   小黑送花()｛
      送的玫瑰花
    ｝
}

小白  implements 送花{  代理类
   小黑类对象;
   小白送花()｛
         亲一口！
         小黑送花();
    ｝
}



根据委托类和代理类实现接口还是继承类，代理分为两种模式：

1.JDK   实现接口
  01.核心类  Proxy
    创建出代理类对象
   public static Object newProxyInstance(ClassLoader loader,
                                            Class<?>[] interfaces,
                                            InvocationHandler h)

ClassLoader loader：类加载器
Class<?>[] interfaces：实现的所有接口
InvocationHandler h ：核心的接口

  02.核心接口  InvocationHandler

 public Object invoke(Object proxy, Method method, Object[] args)

Object proxy：代理类对象
Method method：需要执行的方法
Object[] args：方法的参数




2.CGLIB  继承类 实现接口

01.核心类  Enhancer
  public void setSuperclass(Class superclass)
  设置公共的父类或者是接口
  public void setCallback(Callback callback)

02.核心接口  MethodInterceptor extends Callback

 Object intercept(Object obj, Method method, Object[] agrs, MethodProxy proxy)





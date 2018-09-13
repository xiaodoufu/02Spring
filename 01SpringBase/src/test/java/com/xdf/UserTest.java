package com.xdf;

import com.xdf.pojo.Student;
import com.xdf.service.UserService;
import com.xdf.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UserTest {


    /**
     * 之前的方式
     */
   @Test
    public  void  testBefore(){
       UserService service=new UserServiceImpl();
       service.helloSpring();
   }
    /**
     * Spring管理的方式  ClassPathXmlApplicationContext
     *  我们所有的操作（对象的创建） 都交给了Spring容器
     *  容器===》Spring-base.xml文件
     */
   @Test
    public  void  testSpring(){
       //加载容器
       ApplicationContext context=new ClassPathXmlApplicationContext("Spring-base.xml");
       System.out.println("====================================================");
       //获取指定的对象 UserService service= (UserService) context.getBean("userService");
       UserService service=context.getBean(UserService.class);
       //使用对象的方法
       service.helloSpring();
   }

   @Test
    public  void  testContext(){
       //加载容器
       XmlBeanFactory context=new XmlBeanFactory(new ClassPathResource("Spring-base.xml"));
       System.out.println("====================================================");
       //获取指定的对象
       UserService service= (UserService) context.getBean("userService");
       //使用对象的方法
       service.helloSpring();
   }

    /**
     * 去指定的路径中找到我们的容器 并加载
     */
   @Test
    public  void  testContextPath(){
       //加载容器
       ApplicationContext context=new FileSystemXmlApplicationContext("e:/u3/Spring-base.xml");
       System.out.println("====================================================");
       //获取指定的对象
       UserService service= (UserService) context.getBean("userService");
       //使用对象的方法
       service.helloSpring();
   }


    /**
     * 验证容器中创建的对象 默认就是单例的
     */
    @Test
    public  void  testStudent(){
        //加载容器
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring-base.xml");
        System.out.println("====================================================");
        //获取指定的对象
        Student student1 = (Student) context.getBean("student");
       // student1.setStuId(1);
        //student1.setStuName("小黑");
        System.out.println("student1===>"+student1);
        Student  student2 = (Student) context.getBean("student");
        System.out.println("student2===>"+student2);
        System.out.println(student1==student2);
    }

    /**
     * 验证属性赋值方式
     */
    @Test
    public  void  testProperty(){
        //加载容器
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring-base.xml");
        System.out.println("====================================================");
        //获取指定的对象
        Student student = (Student) context.getBean("student");
        System.out.println("student===>"+student);
    }
    /**
     * 测试属性赋值
     */
    @Test
    public  void  test(){
        //加载容器
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring-base.xml");
        System.out.println("====================================================");
        //获取指定的对象
        Student student = (Student) context.getBean("student");
        Map map = student.getMap();
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }
    }
    /**
     * 测试属性赋值
     */
    @Test
    public  void  test01() {
        //加载容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-autowire.xml");
        System.out.println("====================================================");
        //获取指定的对象
        Student student = (Student) context.getBean("student");
        System.out.println(student.getTeacher());
    }
    /**
     * 测试使用注解完成自动装配
     */
    @Test
    public  void  testAutowire() {
        //加载容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-autowire.xml");
        System.out.println("====================================================");
        //获取指定的对象
        UserService service = (UserService) context.getBean(UserService.class);
        service.helloSpring();
    }
    /**
     * 01.测试管理多个xml文件
     */
    @Test
    public  void  testCore() {
        //加载容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-core.xml");
        System.out.println("====================================================");
        //获取指定的对象
        Student student = (Student) context.getBean(Student.class);
        System.out.println(student.getTeacher());
    }
    /**
     * 02.测试管理多个xml文件  通过传递多个xml文件
     */
    @Test
    public  void  testTwoXml() {
        //加载容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-student.xml","Spring-teacher.xml");
        System.out.println("====================================================");
        //获取指定的对象
        Student student = (Student) context.getBean(Student.class);
        System.out.println(student.getTeacher());
    }






}

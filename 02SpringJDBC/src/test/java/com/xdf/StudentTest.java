package com.xdf;

import com.xdf.dao.StudentDao;
import com.xdf.pojo.Student;
import com.xdf.pojo.TestValue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentTest {

    StudentDao dao=null;
    TestValue  value=null;
    @Before
    public void before(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring-jdbc.xml");
        dao=context.getBean(StudentDao.class);
        value=context.getBean(TestValue.class);
    }

    @Test
    public  void add(){
        Student student=new Student();
        student.setsName("哈哈");
        student.setAge(55);
        dao.add(student);
    }
    @Test
    public  void update(){
        Student student=new Student();
        student.setsId(5);
        student.setsName("哈哈111");
        student.setAge(66);
        dao.update(student);
    }
    @Test
    public  void delete(){
        dao.delete(5);
    }
    @Test
    public  void findAll(){
        List<Student> list = dao.findAllList();
        for (Student student:list) {
            System.out.println(student);
        }
    }


    @Test
    public  void  testValue(){
        System.out.println(value.getName());
    }

}

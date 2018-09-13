package com.xdf.pojo;

import java.io.Serializable;
import java.util.*;

/**
 * 学生类
 */
public class Student implements Serializable {
    private  int stuId;
    private  String stuName;
    private Teacher teacher;  //域属性
    private int [] nums=new int[5];
    private List<String> list=new ArrayList<>();
    private Set<String> set=new HashSet<>();
    private Map map=new HashMap<>();
    private  Properties properties=new Properties();

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                '}';
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Student(int id, String name) {
        this.stuId = id;
        this.stuName = name;
    }

    public Student() {
        System.out.println("Student无参构造");
    }
}

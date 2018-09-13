package com.xdf.service;

import com.xdf.dao.UserDao;
import com.xdf.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl是UserDao的代理类
 * 01.不会改变dao层代码
 * 02.增加业务逻辑
 */
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
    }

    /**
     * 之前的方式 耦合
     private UserDao dao=new UserDaoImpl();
     */

    /**
     * 现在的方式 使用spring容器去创建dao对象
     *    @Autowired 默认是按照类型
     */
    @Autowired
    @Qualifier("userDao")
    private UserDao dao;

    @Override
    public void helloSpring() {
        dao.helloSpring(); //主业务
    }

    /**
     * 创建属性对应的set方法
     * DI 依赖注入
     */
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public UserDao getDao() {
        return dao;
    }
}

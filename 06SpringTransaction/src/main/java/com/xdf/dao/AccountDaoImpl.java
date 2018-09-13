package com.xdf.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
    @Override
    public void updateAccount(String aName, double money) {
        String sql="UPDATE `account` SET balance=balance-? WHERE aname=?";
        getJdbcTemplate().update(sql,money,aName);
    }
}

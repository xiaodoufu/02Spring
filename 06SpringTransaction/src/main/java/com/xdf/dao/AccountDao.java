package com.xdf.dao;

public interface AccountDao {

    /**
     * 谁的账户减钱
     */
    void updateAccount(String aName,double money);
}

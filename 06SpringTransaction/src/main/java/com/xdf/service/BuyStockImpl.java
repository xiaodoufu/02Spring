package com.xdf.service;

import com.xdf.dao.AccountDao;
import com.xdf.dao.StockDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyStockImpl implements BuyStock {

     private StockDao stockDao;
     private AccountDao accountDao;


    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    @Override
    public void buyStock(String name, double money, int mount) {
        //减钱
        accountDao.updateAccount(name,money);
        if (true) throw new RuntimeException("购买股票失败");
        //加股
        stockDao.updateStock(name,mount);
    }

    public StockDao getStockDao() {
        return stockDao;
    }

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}

package com.xdf.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockDaoImpl  extends JdbcDaoSupport implements  StockDao{

    @Override
    public void updateStock(String sName, int mount) {
     String sql="UPDATE `stock` SET amount=amount+? WHERE sname=?";
     getJdbcTemplate().update(sql,mount,sName);
    }
}

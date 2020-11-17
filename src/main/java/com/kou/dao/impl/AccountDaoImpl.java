package com.kou.dao.impl;

import com.kou.dao.IAccountDao;
import org.apache.commons.dbutils.QueryRunner;
import com.kou.domian.Account;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JIAJUN KOU
 * 账户持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account where id=?", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void updateAccount(Account account) {

        try {
            runner.update("update account set name=?,money=? where id=? ",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account where id=?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

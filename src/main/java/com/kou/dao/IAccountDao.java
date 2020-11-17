package com.kou.dao;

import com.kou.domian.Account;

import java.util.List;

/**
 * 账户的持久层jiekou
 *
 * @author dell
 */

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个 通过id
     * @return
     * @param accountId
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 根据id删除账户
     * @param accountId
     */
    void deleteAccount(Integer accountId);


}

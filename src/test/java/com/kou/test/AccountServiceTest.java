package com.kou.test;

import com.kou.config.SpringConfiguration;
import com.kou.domian.Account;
import com.kou.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author JIAJUN KOU
 * spring整个junit配置
 * 1.导入spring整合junit的坐标
 * 2.使用junit的一个注解，把原有的main方法替换成 spring提供的main方法
 * @Runwith
 * 3.告知spring的运行器 spring的Ioc创建是基于xml还是注解的
 * @ContextConfigurtion
 *
 * 当使用spring5版本时候，要求junit必须是高一点版本。
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;
    @Test
    public void testFindAll(){
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //得到spring容器的业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = as.findAccountById(2);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //得到spring容器的业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account=new Account();
        account.setName("王后");
        account.setMoney((float) 5000.0);
        as.saveAccount(account);
        testFindAll();

    }
    @Test
    public void testUpdate(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //得到spring容器的业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = as.findAccountById(4);
        account.setName("王爷");
        account.setMoney(2000f);
        System.out.println(account);
        as.updateAccount(account);
        testFindAll();

    }
    @Test
    public void testDelete(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //得到spring容器的业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        as.deleteAccount(9);
        testFindAll();
    }
}

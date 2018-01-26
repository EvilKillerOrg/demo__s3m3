package com.ek.demo1.test;


import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ek.basic.demo1.dao.IUserInfoDAO;
import com.ek.basic.demo1.po.UserInfoD1;


/**
 * 测试传统dao模式开发
 * @author EK
 * @date 2017年8月28日
 */
public class UserInfoDAOTest {
  
  private static Logger logger = Logger.getLogger(UserInfoDAOTest.class);
  
  private AbstractApplicationContext applicationContext;
  
  @Before
   public void setUp(){
     applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext*.xml");
   }
  
  @Test
  public void testDaoModel() throws Exception{
    IUserInfoDAO userDAO = (IUserInfoDAO) applicationContext.getBean("userInfoDAOImpl");
    UserInfoD1 user = userDAO.findUserInfoById(1);
    logger.debug(user);
    applicationContext.close();
  }

    
}
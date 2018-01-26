package com.ek.demo1.test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ek.basic.demo1.mapper.UserInfoMapper;import com.ek.basic.demo1.po.UserInfoD1;

public class UserInfoMapperTest {
  
  private Logger logger = Logger.getLogger(UserInfoMapperTest.class);
  
  private AbstractApplicationContext applicationContext;
  
  @Before
  public void setUp() throws Exception {
    applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext*.xml");
  }

  @Test
  public void testMapperModel() throws Exception {
    UserInfoMapper userInfoMapper = (UserInfoMapper) applicationContext.getBean("userInfoMapper");
    UserInfoD1 user = userInfoMapper.findUserInfoById(1);
    logger.debug(user);
    applicationContext.close();
  }

}